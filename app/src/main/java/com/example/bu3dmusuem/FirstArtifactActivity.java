package com.example.bu3dmusuem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class FirstArtifactActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_artifact);
        getSupportActionBar().setTitle("Black Pattern Bowl");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        name = (TextView) findViewById(R.id.name);

        textView = (TextView) findViewById(R.id.first_artifact);
        button1 = (Button) findViewById(R.id.buttonBU2828);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFirst3DModel();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;

    }

    public void openFirst3DModel() {

        Intent intent = new Intent(this, First3dModelActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Thai:
                getSupportActionBar().setTitle("ชามลายสีดำสุโขทัย");
                name.setText("ชามลายสีดำสุโขทัย");
                textView.setText("ชื่อวัตถุ ชามลายสีดำสุโขทัย \n\nประเภทการตกแต่ง: ลายสีดำ \n\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย \n\nอายุ: พุทธศตวรรษที่ 20–21 \n\nขนาด: สูง 7.8 ซม. เส้นผ่าศูนย์กลาง 25.7 ซม. \n\nลักษณะ: ชาม ขอบปากแบนผาย ลำตัวลึก เชิงตั้งตรง เขียนสีดำใต้เคลือบใสจรดเชิง ด้านในก้นตรงกลางเขียน ลายปลาในกรอบวงกลม มีรอยวัสดุรองเผาทรงกลมแบน ขอบปากเขียนลายวงแหวน ด้านนอกลายเส้นขนานแนวนอน ก้นไม่เคลือบ เนื้อดินสีน้าตาล");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Bowl");
                name.setText("Black Pattern Bowl");
                textView.setText("Type : Bowl \n\nDecoration type : Black Pattern Bowl Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 7.8 cm. Diameter 25.7 cm. \n\nCharacteristics : A bowl with a flat mouth, deep, upright, black writing under clear glaze. Inside the bottom in the middle, write a fish pattern in a circle frame. There is a trace of flattened secondary material The edge of the mouth is written with a ring pattern. Outside, parallel, horizontal, uncoated bottom, ground texture, brown.");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}