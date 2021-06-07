package com.tovonhuquynh.managebodycondition;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class monangoiy extends AppCompatActivity {
    Button btn_quit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_monangoiy);
        linkview();
    }

    private void linkview() {
        btn_quit = findViewById(R.id.btn_quitgoiy);

        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
