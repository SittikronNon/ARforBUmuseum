package com.example.bu3dmusuem.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bu3dmusuem.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SlideshowFragment extends Fragment implements ValueEventListener {

    private SlideshowViewModel slideshowViewModel;

    TextView textView1,textView2;

    private ImageView perma_1,perma_2;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference firstDatabase = databaseReference.child("PermaExhi").child("perma_one");
    private DatabaseReference firstDatabaseTH = databaseReference.child("PermaExhi_TH").child("perma_one");


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View v = inflater.inflate(R.layout.fragment_slideshow, container, false);
        textView1 = v.findViewById(R.id.PermaExhi);

        perma_1 = v.findViewById(R.id.perma1);
        perma_2 = v.findViewById(R.id.perma2);

        Query query = databaseReference.child("Image").child("permanent");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String perma1 = dataSnapshot.child("perma_1").getValue().toString();

                if (!perma1.isEmpty()) {
                    Picasso.get()
                            .load(perma1)
                            .into(perma_1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String perma2 = dataSnapshot.child("perma_2").getValue().toString();

                if (!perma2.isEmpty()) {
                    Picasso.get()
                            .load(perma2)
                            .into(perma_2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Toolbar toolbar = v.findViewById(R.id.toolbar);

        getViews(v);

        return v;
    }

    @Override
    public void  onCreate(@NonNull Bundle savedInstance) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstance);
    }

    private void getViews(View v) {
        textView1 = (TextView) v.findViewById(R.id.PermaExhi);
        textView2 = (TextView) v.findViewById(R.id.PermaExhi);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("perma_one")){
                String first = dataSnapshot.getValue(String.class);
                textView1.setText(first);
            }

        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    public void onStart() {

        super.onStart();
        firstDatabase.addValueEventListener(this);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Thai:

                Toast.makeText(getActivity(), "ภาษาไทย", Toast.LENGTH_LONG).show();
                textView1.findViewById(R.id.PermaExhi);





                firstDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("perma_one")){
                                String firstTH = dataSnapshot.getValue(String.class);
                                textView1.setText(firstTH);
                            }


                        }
                        firstDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                return true;
            case R.id.English:
                Toast.makeText(getActivity(), "English", Toast.LENGTH_LONG).show();
                textView2.findViewById(R.id.PermaExhi);


                firstDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("perma_one")){
                                String first = dataSnapshot.getValue(String.class);
                                textView2.setText(first);
                            }


                        }
                        firstDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });



                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}