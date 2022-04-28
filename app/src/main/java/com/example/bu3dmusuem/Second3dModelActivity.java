package com.example.bu3dmusuem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Second3dModelActivity extends AppCompatActivity {

    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3d_model);

        buttonBack = (Button) findViewById(R.id.BackToPrevious);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backToPrevious();

            }
        });


        FirebaseApp.initializeApp(this);
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference modelRef = storage.getReference().child("BU2877.glb");




        ArFragment arFragment = (ArFragment) getSupportFragmentManager()
                .findFragmentById(R.id.arFragment);

        findViewById(R.id.btnDownload)
                .setOnClickListener(v -> {

                    try {
                        File file = File.createTempFile("BU2877", "glb");

                        modelRef.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                buildModel(file);

                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();


                    }



                });

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            AnchorNode anchorNode = new AnchorNode(hitResult.createAnchor());
            anchorNode.setRenderable(renderable);
            arFragment.getArSceneView().getScene().addChild(anchorNode);

        });


    }

    private ModelRenderable renderable;

    private void buildModel(File file) {

        RenderableSource renderableSource = RenderableSource
                .builder()
                .setSource(this, Uri.parse(file.getPath()), RenderableSource.SourceType.GLB)
                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                .build();


        ModelRenderable
                .builder()
                .setSource(this, renderableSource)
                .setRegistryId(file.getPath())
                .build()
                .thenAccept(modelRenderable -> {
                    Toast.makeText(this, "Model Built", Toast.LENGTH_SHORT).show();
                    renderable = modelRenderable;
                });
    }

    public void backToPrevious() {

        Intent intent = new Intent(this, ArtifactSecondActivity.class);
        startActivity(intent);

    }
}