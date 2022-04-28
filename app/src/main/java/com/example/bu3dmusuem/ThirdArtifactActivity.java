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

public class ThirdArtifactActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_artifact);
        getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.name3);
        textView = (TextView) findViewById(R.id.third_artifact);
        button1 = (Button) findViewById(R.id.buttonBU2879);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openThird3DModel();
            }
        });
    }



    public void openThird3DModel() {

        Intent intent = new Intent(this, Third3dModelActivity.class);
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
                textView.setText("ชื่อวัตถุ: จานลายสีดำสุโขทัย\n\n" +
                        "\nประเภทการตกแต่ง: ลายสีดำ\n" +
                        "\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย\n" +
                        "\nอายุ: พุทธศตวรรษที่ 20–21\n" +
                        "\nขนาด: สูง 7.2 ซม. เส้นผ่าศูนย์กลาง 29.9 ซม.\n" +
                        "\nลักษณะ: จาน ขอบปากแบนผาย ตัวลึก เชิงตั้งตรง ขอบเชิงบาง เขียนสีดำใต้เคลือบไม่จรดเชิง ด้านในตรงกลางเขียนลายปลาในกรอบวงกลม มีรอยวัสดุรองเผาทรงกลมแบน ลำตัวลายดอกไม้ก้านแบ่ง ขอบปากเขียน ลายเส้นโค้งในกรอบเส้นขนานแนวนอน ด้านนอกลายเส้นโค้งในกรอบเส้นขนานแนวนอน ก้นไม่เคลือบ เนื้อดิน สีน้ำตาลเข้ม");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
                name.setText("Black Pattern Dish Sukhothai");
                textView.setText("Type : Plate \n\nDecoration type : Black Pattern Dish Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 7.2 cm. Diameter 29.9 cm. \n\nCharacteristics : The plate has a flat, deep, upright edge. Thin edge is written in black.In the middle of writing a fish pattern in a circle frame There is a trace of the secondary burnt material, a round, flat shape, a flower pattern, a stem dividing the mouth, writing \nCurved lines in a horizontal parallel frame Outwardly, curved lines in a horizontal parallel frame, uncoated bottom. Dark brown");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}