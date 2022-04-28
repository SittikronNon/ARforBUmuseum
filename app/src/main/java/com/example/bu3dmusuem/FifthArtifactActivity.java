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

public class FifthArtifactActivity extends AppCompatActivity {


    private Button button1;
    private TextView textView,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_artifact);
        getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.name5);
        button1 = (Button) findViewById(R.id.buttonBU2895);
        textView = (TextView) findViewById(R.id.fifth_artifact);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFifth3DModel();
            }
        });

    }

    public void openFifth3DModel() {

        Intent intent = new Intent(this, Fifth3dModelActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Thai:
                getSupportActionBar().setTitle("จานลายสีดำสุโขทัย");
                name.setText("จานลายสีดำสุโขทัย");
                textView.setText("ชชื่อวัตถุ: จานลายสีดำสุโขทัย\n" +
                        "\nประเภทการตกแต่ง: ลายสีดำ\n" +
                        "\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย\n" +
                        "\nอายุ: พุทธศตวรรษที่ 20–21\n" +
                        "\nขนาด: สูง 5.9 ซม. เส้นผ่าศูนย์กลาง 20.0 ซม.\n" +
                        "\nลักษณะ: จาน ขอบปากแบนผาย ตัวลึก เชิงตั้งตรง ขอบเชิงบาง เขียนสีดำใต้เคลือบไม่จรดเชิง ด้านในตรง กลางเขียนลายช่อดอกไม้ในกรอบวงกลม มีรอยวัสดุรองเผาทรงกลมแบน ขอบปากเขียนลายตวัดปลายพู่กัน ด้านนอกลายเส้นตรงแนวนอน ก้นไม่เคลือบ เนื้อดินสีน้ำตาล");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
                name.setText("Black Pattern Dish Sukhothai");
                textView.setText("Type : Plate \n\nDecoration type : Black Pattern Dish Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 5.9 cm. Diameter 20.0 cm. \n\nCharacteristics : The plate has a flat, deep, upright edge. Thin edge is written in black. In the middle, write a bouquet of flowers in a circle frame. There is a trace of flattened secondary material The edge of the mouth is written with a flick pattern at the tip of the brush. Horizontal straight line exterior, uncoated bottom, brown soil texture");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
