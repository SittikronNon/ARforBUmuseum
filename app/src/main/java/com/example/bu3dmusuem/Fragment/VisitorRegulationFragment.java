package com.example.bu3dmusuem.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bu3dmusuem.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VisitorRegulationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisitorRegulationFragment extends Fragment implements ValueEventListener {

    TextView groupTitleEN,groupTitleTH,groupEN,groupTH,photoTitleEN,photoTitleTH,photoEN,photoTH,generalTitleEN,generalTitleTH,generalEN,generalTH;
    ImageView visitimg;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference groupTitleDatabase = databaseReference.child("Visit").child("group_Title");
    private DatabaseReference firstDatabase = databaseReference.child("Visit").child("group_visit");
    private DatabaseReference photoTitleDatabase = databaseReference.child("Visit").child("photo_Title");
    private DatabaseReference secondDatabase = databaseReference.child("Visit").child("photo");
    private DatabaseReference generalTitleDatabase = databaseReference.child("Visit").child("general_Title");
    private DatabaseReference thirdDatabase = databaseReference.child("Visit").child("general");

    private DatabaseReference groupTitleDatabaseTH = databaseReference.child("Visit_TH").child("group_Title");
    private DatabaseReference firstDatabaseTH = databaseReference.child("Visit_TH").child("group_visit");
    private DatabaseReference photoTitleDatabaseTH = databaseReference.child("Visit_TH").child("photo_Title");
    private DatabaseReference secondDatabaseTH = databaseReference.child("Visit_TH").child("photo");
    private DatabaseReference generalTitleDatabaseTH = databaseReference.child("Visit_TH").child("general_Title");
    private DatabaseReference thirdDatabaseTH = databaseReference.child("Visit_TH").child("general");

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VisitorRegulationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VisitorRegulationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisitorRegulationFragment newInstance(String param1, String param2) {
        VisitorRegulationFragment fragment = new VisitorRegulationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_visitor_regulation, container, false);

        visitimg = v.findViewById(R.id.visit_img);

        Query query = databaseReference.child("Image").child("visit");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String vis1 = dataSnapshot.child("visit_1").getValue().toString();

                if (!vis1.isEmpty()) {
                    Picasso.get()
                            .load(vis1)
                            .into(visitimg);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        getViews(v);


        return v;
    }


    private void getViews(View v) {

        groupTitleEN = v.findViewById(R.id.group_Title);
        groupEN = v.findViewById(R.id.group_visit);
        photoTitleEN = v.findViewById(R.id.photo_Title);
        photoEN = v.findViewById(R.id.photography);
        generalTitleEN = v.findViewById(R.id.general_Title);
        generalEN = v.findViewById(R.id.general);

        groupTitleTH = v.findViewById(R.id.group_Title);
        groupTH = v.findViewById(R.id.group_visit);
        photoTitleTH = v.findViewById(R.id.photo_Title);
        photoTH = v.findViewById(R.id.photography);
        generalTitleTH = v.findViewById(R.id.general_Title);
        generalTH = v.findViewById(R.id.general);



    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("group_visit")){
                String first = dataSnapshot.getValue(String.class);
                groupEN.setText(first);
            }
            if (key.equals("photo")){
                String second = dataSnapshot.getValue(String.class);
                photoEN.setText(second);
            }
            if (key.equals("general")){
                String third = dataSnapshot.getValue(String.class);
                generalEN.setText(third);
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
        thirdDatabase.addValueEventListener(this);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Thai:

                Toast.makeText(getActivity(), "ภาษาไทย", Toast.LENGTH_LONG).show();



                groupTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("group_Title")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                groupTitleTH.setText(firstTH);
                            }


                        }
                        groupTitleDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                firstDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("group_visit")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                groupTH.setText(firstTH);
                            }


                        }
                        firstDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                photoTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("photo_Title")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                photoTitleTH.setText(secondTH);
                            }


                        }
                        photoTitleDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                secondDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("photo")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                photoTH.setText(secondTH);
                            }


                        }
                        secondDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                generalTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("general_Title")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                generalTitleTH.setText(thirdTH);
                            }


                        }
                        generalTitleDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                thirdDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("general")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                generalTH.setText(thirdTH);
                            }


                        }
                        thirdDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                return true;
            case R.id.English:
                Toast.makeText(getActivity(), "English", Toast.LENGTH_LONG).show();

                groupTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("group_Title")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                groupTitleEN.setText(firstTH);
                            }


                        }
                        groupTitleDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                firstDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("group_visit")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                groupEN.setText(firstTH);
                            }


                        }
                        firstDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                photoTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("photo_Title")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                photoTitleEN.setText(secondTH);
                            }


                        }
                        photoTitleDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                secondDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("photo")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                photoEN.setText(secondTH);
                            }


                        }
                        secondDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                generalTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("general_Title")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                generalTitleEN.setText(thirdTH);
                            }


                        }
                        generalTitleDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                thirdDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("general")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                generalEN.setText(thirdTH);
                            }


                        }
                        thirdDatabase.addValueEventListener(this);

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
