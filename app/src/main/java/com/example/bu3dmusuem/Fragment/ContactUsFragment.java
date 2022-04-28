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
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment implements ValueEventListener {

    TextView addressTitleEN,addressTitleTH,addressEN,addressTH,telTitleTH,telTitleEN,telEN,telTH,faxTitleEN,faxTitleTH,faxEN,faxTH,emailTitleEN,emailTitleTH,emailEN,emailTH;
    ImageView contactimg;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference addressTitleDatabase = databaseReference.child("Address").child("address_Title");
    private DatabaseReference firstDatabase = databaseReference.child("Address").child("address");
    private DatabaseReference telTitleDatabase = databaseReference.child("Address").child("Tel_Title");
    private DatabaseReference secondDatabase = databaseReference.child("Address").child("Tel");
    private DatabaseReference faxTitleDatabase = databaseReference.child("Address").child("Fax_Title");
    private DatabaseReference thirdDatabase = databaseReference.child("Address").child("Fax");
    private DatabaseReference emailTitleDatabase = databaseReference.child("Address").child("Email_Title");
    private DatabaseReference fourthDatabase = databaseReference.child("Address").child("Email");


    private FirebaseDatabase firebaseDatabaseTH = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReferenceTH = firebaseDatabase.getReference();
    private DatabaseReference addressTitleDatabaseTH = databaseReference.child("Address_TH").child("address_Title");
    private DatabaseReference firstDatabaseTH = databaseReference.child("Address_TH").child("address");
    private DatabaseReference telTitleDatabaseTH = databaseReference.child("Address_TH").child("Tel_Title");
    private DatabaseReference secondDatabaseTH = databaseReference.child("Address_TH").child("Tel");
    private DatabaseReference faxTitleDatabaseTH = databaseReference.child("Address_TH").child("Fax_Title");
    private DatabaseReference thirdDatabaseTH = databaseReference.child("Address_TH").child("Fax");
    private DatabaseReference emailTitleDatabaseTH = databaseReference.child("Address_TH").child("Email_Title");
    private DatabaseReference fourthDatabaseTH = databaseReference.child("Address_TH").child("Email");

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactUsFragment newInstance(String param1, String param2) {
        ContactUsFragment fragment = new ContactUsFragment();
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
            setHasOptionsMenu(true);
            

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact_us, container, false);

        contactimg = v.findViewById(R.id.contact_img);

        Query query = databaseReference.child("Image").child("contact_us");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String con1 = dataSnapshot.child("contact_1").getValue().toString();

                if (!con1.isEmpty()) {
                    Picasso.get()
                            .load(con1)
                            .into(contactimg);
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

        addressTitleEN = v.findViewById(R.id.address_Title);
        addressEN = v.findViewById(R.id.contact_address);
        telTitleEN = v.findViewById(R.id.tel_Title);
        telEN = v.findViewById(R.id.contact_tel);
        faxTitleEN = v.findViewById(R.id.fax_Title);
        faxEN = v.findViewById(R.id.contact_fax);
        emailTitleEN = v.findViewById(R.id.email_Title);
        emailEN = v.findViewById(R.id.contact_Email);

        addressTitleTH = v.findViewById(R.id.address_Title);
        addressTH = v.findViewById(R.id.contact_address);
        telTitleTH = v.findViewById(R.id.tel_Title);
        telTH = v.findViewById(R.id.contact_tel);
        faxTitleTH = v.findViewById(R.id.fax_Title);
        faxTH = v.findViewById(R.id.contact_fax);
        emailTitleTH = v.findViewById(R.id.email_Title);
        emailTH = v.findViewById(R.id.contact_Email);

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        if (dataSnapshot.getValue(String.class)!=null) {

            String key = dataSnapshot.getKey();
            if (key.equals("address")){
                String first = dataSnapshot.getValue(String.class);
                addressEN.setText(first);
            }
            if (key.equals("Tel")){
                String second = dataSnapshot.getValue(String.class);
                telEN.setText(second);
            }
            if (key.equals("Fax")){
                String third = dataSnapshot.getValue(String.class);
                faxEN.setText(third);
            }
            if (key.equals("Email")){
                String fourth = dataSnapshot.getValue(String.class);
                emailEN.setText(fourth);
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
        fourthDatabase.addValueEventListener(this);



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



                addressTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("address_Title")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                addressTitleTH.setText(firstTH);
                            }


                        }
                        addressTitleDatabaseTH.addValueEventListener(this);

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
                            if (key.equals("address")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                addressTH.setText(firstTH);
                            }


                        }
                        firstDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                telTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Tel_Title")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                telTitleTH.setText(secondTH);
                            }


                        }
                        telTitleDatabaseTH.addValueEventListener(this);

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
                            if (key.equals("Tel")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                telTH.setText(secondTH);
                            }


                        }
                        secondDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                faxTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Fax_Title")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                faxTitleTH.setText(thirdTH);
                            }


                        }
                        faxTitleDatabaseTH.addValueEventListener(this);

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
                            if (key.equals("Fax")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                faxTH.setText(thirdTH);
                            }


                        }
                        thirdDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                emailTitleDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Email_Title")) {
                                String fourthTH = dataSnapshot.getValue(String.class);
                                emailTitleTH.setText(fourthTH);
                            }


                        }
                        emailTitleDatabaseTH.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                fourthDatabaseTH.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Email")) {
                                String fourthTH = dataSnapshot.getValue(String.class);
                                emailTH.setText(fourthTH);
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

                addressTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("address_Title")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                addressTitleTH.setText(firstTH);
                            }


                        }
                        addressTitleDatabase.addValueEventListener(this);

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
                            if (key.equals("address")) {
                                String firstTH = dataSnapshot.getValue(String.class);
                                addressEN.setText(firstTH);
                            }


                        }
                        firstDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                telTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Tel_Title")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                telTitleEN.setText(secondTH);
                            }


                        }
                        telTitleDatabase.addValueEventListener(this);

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
                            if (key.equals("Tel")) {
                                String secondTH = dataSnapshot.getValue(String.class);
                                telEN.setText(secondTH);
                            }


                        }
                        secondDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                faxTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Fax_Title")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                faxTitleEN.setText(thirdTH);
                            }


                        }
                        faxTitleDatabase.addValueEventListener(this);

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
                            if (key.equals("Fax")) {
                                String thirdTH = dataSnapshot.getValue(String.class);
                                faxEN.setText(thirdTH);
                            }


                        }
                        thirdDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                emailTitleDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Email_Title")) {
                                String fourthTH = dataSnapshot.getValue(String.class);
                                emailTitleEN.setText(fourthTH);
                            }


                        }
                        emailTitleDatabase.addValueEventListener(this);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }

                });

                fourthDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue(String.class) != null) {

                            String key = dataSnapshot.getKey();
                            if (key.equals("Email")) {
                                String fourthTH = dataSnapshot.getValue(String.class);
                                emailEN.setText(fourthTH);
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