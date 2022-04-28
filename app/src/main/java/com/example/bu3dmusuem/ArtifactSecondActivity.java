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

public class ArtifactSecondActivity extends AppCompatActivity {

    private Button button1;

    private TextView textView,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artifact_second);
        getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.name2);
        textView = (TextView) findViewById(R.id.second_artifact);
        button1 = (Button) findViewById(R.id.buttonBU2877);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSecond3DModel();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;

    }

    public void openSecond3DModel() {

        Intent intent = new Intent(this, Second3dModelActivity.class);
        startActivity(intent);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Thai:
                getSupportActionBar().setTitle("จานลายสีดำสุโขทัย");
                name.setText("จานลายสีดำสุโขทัย");
                textView.setText("ชื่อวัตถุ: จานลายสีดำสุโขทัย\n" +
                        "\nประเภทการตกแต่ง: ลายสีดำ\n" +
                        "\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย\n" +
                        "\nอายุ: พุทธศตวรรษที่ 20–21\n" +
                        "\nขนาด: สูง 7.5 ซม. เส้นผ่าศูนย์กลาง 31.2 ซม.\n" +
                        "\nลักษณะ: จาน ขอบปากแบนผาย ตัวลึก เชิงตั้งตรง ขอบเชิงบาง เขียนสีดำใต้เคลือบไม่จรดเชิง ด้านในตรงกลางเขียนลายปลาคู่กำลังกินพันธุ์ไม้น้ำในกรอบวงกลม มีรอยวัสดุรองเผาทรงกลมแบน ลำตัวลายดอกไม้ก้าน ขด ขอบปากเขียนลายก้านขด ด้านนอกลายก้านขดในกรอบเส้นขนานแนวนอน ก้นไม่เคลือบ เนื้อดินสีน้ำตาล เข้ม มีรอยวัสดุรองเผา");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
                name.setText("Black Pattern Dish Sukhothai");
                textView.setText("Type : Plate \n\nDecoration type : Black Pattern Dish Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 7.5 cm. Diameter 31.2 cm. \n\nCharacteristics : The plate has a flat, deep, upright edge. Thin edge is written in black. In the middle of writing a double fish pattern They are eating plants in a circular frame with marks, a circular substrate, a flat shape, a flower stalk. \\nCurl the edge of the mouth, write with Kan Khot pattern. On the outside, Kan Khot pattern in a horizontal parallel frame, uncoated bottom, brown soil texture. Dark, wth burn marks");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
