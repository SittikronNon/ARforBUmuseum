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
 * Use the {@link OpeningHoursFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OpeningHoursFragment extends Fragment implements ValueEventListener {

    TextView textENopening,textENopening2,titleOpeningTH,titleOpeningEN,textTHopening,titleCalendarTH,titleCalendarEN,textTHopening2;
    ImageView openingimg;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference firstDatabase = databaseReference.child("Opening Hours").child("opening_Title");
    private DatabaseReference secondDatabase = databaseReference.child("Opening Hours").child("opening_one");
    private DatabaseReference thirdDatabase = databaseReference.child("Opening Hours").child("opening_calendar");
    private DatabaseReference fourthDatabase = databaseReference.child("Opening Hours").child("opening_two");
    private DatabaseReference firstDatabaseTH = databaseReference.child("Opening Hours_TH").child("opening_Title");
    private DatabaseReference secondDatabaseTH = databaseReference.child("Opening Hours_TH").child("opening_one");
    private DatabaseReference thirdDatabaseTH = databaseReference.child("Opening Hours_TH").child("opening_calendar");
    private DatabaseReference fourthDatabaseTH = databaseReference.child("Opening Hours_TH").child("opening_two");


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OpeningHoursFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OpeningHoursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OpeningHoursFragment newInstance(String param1, String param2) {
        OpeningHoursFragment fragment = new OpeningHoursFragment();
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
        View v = inflater.inflate(R.layout.fragment_opening_hours, container, false);

        textENopening = v.findViewById(R.id.opening_text_one);
        textENopening2 = v.findViewById(R.id.opening_text_two);

        openingimg = v.findViewById(R.id.opening_img);


        Query query = databaseReference.child("Image").child("opening");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String open1 = dataSnapshot.child("opening_1").getValue().toString();

                if (!open1.isEmpty()) {
                    Picasso.get()
                            .load(open1)
                            .into(openingimg);
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





    private void getViews(View v) {
        textENopening = (TextView) v.findViewById(R.id.opening_text_one);
        textENopening2 = (TextView) v.findViewById(R.id.opening_text_two);
        titleCalendarEN = (TextView) v.findViewById(R.id.titleCalendar);
        titleCalendarTH = (TextView) v.findViewById(R.id.titleCalendar);
        titleOpeningTH = (TextView) v.findViewById(R.id.titleOpening);
        titleOpeningEN = (TextView) v.findViewById(R.id.titleOpening);
        textTHopening = (TextView) v.findViewById(R.id.opening_text_one);
        textTHopening2 = (TextView) v.findViewById(R.id.opening_text_two);



    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("opening_one")){
                String first = dataSnapshot.getValue(String.class);
                textENopening.setText(first);
            }
            if (key.equals("opening_two")){
                String second = dataSnapshot.getValue(String.class);
                textENopening2.setText(second);
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

                firstDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_Title")){
                                String firstTH = dataSnapshot.getValue(String.class);
                                titleOpeningTH.setText(firstTH);
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
                            if (key.equals("opening_one")){
                                String secondTH = dataSnapshot.getValue(String.class);
                                textTHopening.setText(secondTH);
                            }


                        }
                        secondDatabaseTH.addValueEventListener(this);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                thirdDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_calendar")){
                                String thirdTH = dataSnapshot.getValue(String.class);
                                titleCalendarTH.setText(thirdTH);
                            }


                        }
                        thirdDatabaseTH.addValueEventListener(this);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                fourthDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_two")){
                                String fourtTH = dataSnapshot.getValue(String.class);
                                textTHopening2.setText(fourtTH);
                            }


                        }
                        fourthDatabaseTH.addValueEventListener(this);

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
                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_Title")){
                                String first = dataSnapshot.getValue(String.class);
                                titleOpeningEN.setText(first);
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
                            if (key.equals("opening_one")){
                                String second = dataSnapshot.getValue(String.class);
                                textENopening.setText(second);
                            }


                        }
                        secondDatabase.addValueEventListener(this);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                thirdDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_calendar")){
                                String third = dataSnapshot.getValue(String.class);
                                titleCalendarEN.setText(third);
                            }


                        }
                        thirdDatabase.addValueEventListener(this);

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                fourthDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue(String.class)!=null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("opening_two")){
                                String fourth = dataSnapshot.getValue(String.class);
                                textENopening2.setText(fourth);
                            }


                        }
                        fourthDatabase.addValueEventListener(this);

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