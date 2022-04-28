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

public class FourthArtifactActivity extends AppCompatActivity {


    private Button button1;
    private TextView textView,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_artifact);
        getSupportActionBar().setTitle("Black Pattern Bowl Sukhothai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.name4);
        textView = (TextView) findViewById(R.id.fourth_artifact);
        button1 = (Button) findViewById(R.id.buttonBU2893);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFourth3DModel();
            }
        });

    }

    public void openFourth3DModel() {

        Intent intent = new Intent(this, Fourth3dModelActivity.class);
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
                getSupportActionBar().setTitle("ชามลายสีดำสุโขทัย");
                name.setText("ชามลายสีดำสุโขทัย");
                textView.setText("ชื่อวัตถุ: ชามลายสีดำสุโขทัย\n" +
                        "\nประเภทการตกแต่ง: ลายสีดำ\n" +
                        "\nแหล่งผลิต: เตาสุโขทัย จังหวัดสุโขทัย\n" +
                        "\nอายุ: พุทธศตวรรษที่ 20–21\n" +
                        "\nขนาด: สูง 7.6 ซม. เส้นผ่าศูนย์กลาง 21.9 ซม.\n" +
                        "\nลักษณะ: ชาม ตัวลึก เชิงตั้งตรง ขอบเชิงบาง เขียนสีดำใต้เคลือบไม่จรดเชิง ด้านในตรงกลางเขียนลายจักรใน กรอบวงกลม มีรอยวัสดุรองเผาทรงกลมแบน ลำตัวเขียนลายตวัดปลายพู่กัน ขอบปากลายเส้นวงแหวน ด้าน นอกลายเส้นขนานแนวนอน ก้นไม่เคลือบ เนื้อดินสีน้ำตาลอมสีแดง");


                return true;
            case R.id.English:
                getSupportActionBar().setTitle("Black Pattern Bowl Sukhothai");
                name.setText("Black Pattern Bowl Sukhothai");
                textView.setText("Type : Bowl \n\nDecoration type : Black Pattern Bowl Sukhothai \n\nProduction sites : Sukhothai Kiln, Sukhothai Province \n\nAge : 20-21 Buddhist century \n\nSize : height 7.6 cm. Diameter 21.9 cm. \n\nCharacteristics : The bowl is deep, upright, with a thin edge, painted in black, glazed not to the foot. Inside the middle, write a machine pattern inside The circle frame has a scratch, a circular substrate, a flat round, the writing pattern of the brush tip. Lip line Outside, horizontal parallel lines, uncoated bottom, earthy texture, brownish red");


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}