package com.example.bu3dmusuem.ui.gallery;

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
import androidx.navigation.ui.AppBarConfiguration;

import com.example.bu3dmusuem.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class GalleryFragment extends Fragment implements ValueEventListener {

    private GalleryViewModel galleryViewModel;
    TextView textView1,textView2,textView3,textView4;
    TextView textPerma;

    private ImageView his_img1,his_img2;

    boolean isVisited = false;
    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference firstDatabaseTH = databaseReference.child("History_TH").child("history_one");
    private DatabaseReference secondDatabaseTH = databaseReference.child("History_TH").child("history_two");
    private DatabaseReference firstDatabase = databaseReference.child("History").child("history_one");
    private DatabaseReference secondDatabase = databaseReference.child("History").child("history_two");






    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View v;
        v = inflater.inflate(R.layout.fragment_gallery, container, false);

        his_img1 = v.findViewById(R.id.history_img1);
        his_img2 = v.findViewById(R.id.history_img2);


        Query query = databaseReference.child("Image").child("history");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String history_1 = dataSnapshot.child("history_1").getValue().toString();

                if (!history_1.isEmpty()) {
                    Picasso.get()
                            .load(history_1)
                            .into(his_img1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String history_2 = dataSnapshot.child("history_2").getValue().toString();

                if (!history_2.isEmpty()) {
                    Picasso.get()
                            .load(history_2)
                            .into(his_img2);
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
        textView1 = (TextView) v.findViewById(R.id.history_first);
        textView2 = (TextView) v.findViewById(R.id.history_second);
        textView3 = (TextView) v.findViewById(R.id.history_first);
        textView4 = (TextView) v.findViewById(R.id.history_second);
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("history_one")){
                String first = dataSnapshot.getValue(String.class);
                textView1.setText(first);
            }
            if (key.equals("history_two")){
                String second = dataSnapshot.getValue(String.class);
                textView2.setText(second);
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
        secondDatabase.addValueEventListener(this);

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
                    textView1.findViewById(R.id.history_first);
                    textView2.findViewById(R.id.history_second);




                    firstDatabaseTH.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue(String.class)!=null) {

                                String key = dataSnapshot.getKey();
                                if (key.equals("history_one")){
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

                    secondDatabaseTH.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.getValue(String.class)!=null) {

                                String key = dataSnapshot.getKey();
                                if (key.equals("history_two")){
                                    String secondTH = dataSnapshot.getValue(String.class);
                                    textView2.setText(secondTH);
                                }


                            }
                            secondDatabaseTH.addValueEventListener(this);

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    return true;
                case R.id.English:
                    Toast.makeText(getActivity(), "English", Toast.LENGTH_LONG).show();
                    textView3.findViewById(R.id.history_first);
                    textView4.findViewById(R.id.history_second);

                    firstDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue(String.class)!=null) {

                                String key = dataSnapshot.getKey();
                                if (key.equals("history_one")){
                                    String first = dataSnapshot.getValue(String.class);
                                    textView3.setText(first);
                                }


                            }
                            firstDatabase.addValueEventListener(this);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {


                        }

                    });

                    secondDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.getValue(String.class)!=null) {

                                String key = dataSnapshot.getKey();
                                if (key.equals("history_two")){
                                    String second = dataSnapshot.getValue(String.class);
                                    textView4.setText(second);
                                }


                            }
                            secondDatabase.addValueEventListener(this);

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