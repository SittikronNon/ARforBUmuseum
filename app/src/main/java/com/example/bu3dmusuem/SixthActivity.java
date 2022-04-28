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

public class SixthActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.name6);
        button1 = (Button) findViewById(R.id.buttonBU2896);
        textView = (TextView) findViewById(R.id.sixth_artifact);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSixth3DModel();
            }
        });

    }

    public void openSixth3DModel() {

        Intent intent = new Intent(this, Sixth3dModelActivity.class);
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
                textView.setText("ชื่อวัตถุ: จานลายสีดำสุโขทัย\n" +
                        "\nประเภทการตกแต่ง: ลายสีดำ\n" +
                        "\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย\n" +
                        "\nอายุ: พุทธศตวรรษที่ 20–21\n" +
                        "\nขนาด: สูง 6.0 ซม. เส้นผ่าศูนย์กลาง 25.0 ซม.\n" +
                        "\nลักษณะ: จาน ตัวลึก เชิงตั้งตรง ขอบเชิงบาง เขียนสีดำใต้เคลือบไม่จรดเชิง ด้านในตรงกลางเขียนลายก้านขุด ในกรอบวงแหวน มีรอยวัสดุรองเผาทรงกลมแบน ด้านนอกลายเส้นขนานแนวนอน ก้นไม่เคลือบ เนื้อดินสีน้ำตาล");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Dish Sukhothai");
                name.setText("Black Pattern Dish Sukhothai");
                textView.setText("Type : Plate \n\nDecoration type : Black Pattern Dish Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 6.0 cm. Diameter 25.0 cm. \n\nCharacteristics : Deep body plate, upright, thin edge, underneath painted, glazed not to the foot. Inside the middle, write a stem dig pattern. In the ring frame there is a trace of a flat circular burner material. Outside, parallel lines, horizontal, uncoated bottom, earthy texture Sugar");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}