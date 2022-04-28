package com.example.bu3dmusuem.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bu3dmusuem.ArtifactSecondActivity;
import com.example.bu3dmusuem.FifthArtifactActivity;
import com.example.bu3dmusuem.FirstArtifactActivity;
import com.example.bu3dmusuem.FourthArtifactActivity;
import com.example.bu3dmusuem.R;
import com.example.bu3dmusuem.SixthActivity;
import com.example.bu3dmusuem.ThirdArtifactActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6;
    private TextView textView1,textView2,textView3,textView4,textView5,textView6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        textView1 = view.findViewById(R.id.firstText);
        textView2 = view.findViewById(R.id.secondText);
        textView3 = view.findViewById(R.id.thirdText);
        textView4    = view.findViewById(R.id.fourthText);
        textView5 = view.findViewById(R.id.fifthText);
        textView6    = view.findViewById(R.id.sixthText);

        cardView1 = view.findViewById(R.id.cardbu2828);
        cardView2 = view.findViewById(R.id.cardbu2877);
        cardView3 = view.findViewById(R.id.cardbu2879);
        cardView4 = view.findViewById(R.id.cardbu2893);
        cardView5 = view.findViewById(R.id.cardbu2895);
        cardView6 = view.findViewById(R.id.cardbu2896);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), FirstArtifactActivity.class));

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ArtifactSecondActivity.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ThirdArtifactActivity.class));
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FourthArtifactActivity.class));
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FifthArtifactActivity.class));
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SixthActivity.class));
            }
        });


        return view;
    }

    @Override
    public void  onCreate(@NonNull Bundle savedInstance) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstance);
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
                textView1.setText("ชามลายสีดำสุโขทัย");
                textView2.setText("จานลายสีดำสุโขทัย");
                textView3.setText("จานลายสีดำสุโขทัย");
                textView4.setText("ชามลายสีดำสุโขทัย");
                textView5.setText("จานลายสีดำสุโขทัย");
                textView6.setText("จานลายสีดำสุโขทัย");


                return true;
            case R.id.English:

                textView1.setText("Black Pattern Bowl Sukhothai");
                textView2.setText("Black Pattern Dish Sukhothai");
                textView3.setText("Black Pattern Dish Sukhothai");
                textView4.setText("Black Pattern Bowl Sukhothai");
                textView5.setText("Black Pattern Dish Sukhothai");
                textView6.setText("Black Pattern Dish Sukhothai");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}