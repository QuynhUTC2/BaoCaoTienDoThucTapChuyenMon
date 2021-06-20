package com.tovonhuquynh.managebodycondition;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class monangoiy extends AppCompatActivity {
    Button btn_quit;
    TextView txt_mon1,txt_mon2,txt_mon3,txt_mon4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_monangoiy);
        linkview();
        addevent();
    }

    private void addevent() {
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String buaan = getIntent().getStringExtra("buaan");
        if (buaan.equals("Bữa trưa")){
            txt_mon1.setText("Cơm với canh bí đỏ thịt băm");
            txt_mon2.setText("Cơm với thịt luộc kèm salad");
            txt_mon3.setText("Cháo thịt băm rau củ");
            txt_mon4.setText("Cơm thịt nướng một quả táo");
        }else if (buaan.equals("Bữa tối")){
            txt_mon1.setText("Cháo sườn bò với 1 quả ");
            txt_mon2.setText("Sửa gạo với bò hun khói ");
            txt_mon3.setText("Salad với thịt bò xé");
            txt_mon4.setText("Bò lúc lắc khoai tây nghiền ");
        }
    }

    private void linkview() {
        btn_quit = findViewById(R.id.btn_quitgoiy);
        txt_mon1 = findViewById(R.id.txt_mon1);
        txt_mon2 = findViewById(R.id.txt_mon2);
        txt_mon3 = findViewById(R.id.txt_mon3);
        txt_mon4 = findViewById(R.id.txt_mon4);
    }
}
