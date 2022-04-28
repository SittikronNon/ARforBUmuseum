package com.example.bu3dmusuem.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
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
 * Use the {@link GettingHereFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GettingHereFragment extends Fragment implements ValueEventListener {

    TextView titleEN,titleTH,textEN,textTH;
    ImageView gettingimg;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference firstDatabase = databaseReference.child("GettingHere").child("getting_Title");
    private DatabaseReference secondDatabase = databaseReference.child("GettingHere").child("gettinghere");
    private DatabaseReference firstDatabaseTH = databaseReference.child("Getting Here_TH").child("gettinghere_Title");
    private DatabaseReference secondDatabaseTH = databaseReference.child("Getting Here_TH").child("gettinghere_text");


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GettingHereFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GettingHereFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GettingHereFragment newInstance(String param1, String param2) {
        GettingHereFragment fragment = new GettingHereFragment();
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
        View v = inflater.inflate(R.layout.fragment_getting_here, container, false);

        Toolbar toolbar = v.findViewById(R.id.toolbar);

        textEN= v.findViewById(R.id.gettinghere_text);
        gettingimg = v.findViewById(R.id.getting_img);

        Query query = databaseReference.child("Image").child("gettinghere");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String get1 = dataSnapshot.child("getting_1").getValue().toString();

                if (!get1.isEmpty()) {
                    Picasso.get()
                            .load(get1)
                            .into(gettingimg);
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
        textEN = (TextView) v.findViewById(R.id.gettinghere_text);
        textTH = (TextView) v.findViewById(R.id.gettinghere_text);
        titleEN = (TextView) v.findViewById(R.id.getting_Title);
        titleTH = (TextView) v.findViewById(R.id.getting_Title);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("gettinghere_text")){
                String first = dataSnapshot.getValue(String.class);
                textEN.setText(first);
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
        switch (item.getItemId()) {
            case R.id.Thai:

                Toast.makeText(getActivity(), "ภาษาไทย", Toast.LENGTH_LONG).show();



                firstDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("gettinghere_Title")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                titleTH.setText(firstTH);
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
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("gettinghere_text")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                textTH.setText(secondTH);
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



                firstDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("getting_Title")) {
                                String firsttitle = dataSnapshot.getValue(String.class);
                                titleEN.setText(firsttitle);
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
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("gettinghere")) {
                                String secondText = dataSnapshot.getValue(String.class);
                                textEN.setText(secondText);
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