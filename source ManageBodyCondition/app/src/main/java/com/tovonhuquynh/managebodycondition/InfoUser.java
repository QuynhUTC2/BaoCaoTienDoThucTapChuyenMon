package com.tovonhuquynh.managebodycondition;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoUser extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 1;
    Button btn_nextInfo;
    EditText edt_Username, edt_height, edt_weight, edt_Sex, edt_chest, edt_waist, edt_hips;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infouser);

        linkview();
        addevent();
    }

    private void addevent() {

        btn_nextInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iduser = 0 ;
                String userName = edt_Username.getText().toString();
                String Sex = edt_Sex.getText().toString();
                Double height = Double.parseDouble(edt_height.getText().toString());
                Double weight = Double.parseDouble(edt_weight.getText().toString());
                Double chest = Double.parseDouble(edt_chest.getText().toString());
                Double waist = Double.parseDouble(edt_waist.getText().toString());
                Double hips = Double.parseDouble(edt_hips.getText().toString());
                int soluID =0;

                com.tovonhuquynh.model.InfoUser infoUser = new com.tovonhuquynh.model.InfoUser(iduser, Sex, height, weight, chest, waist, hips, userName,soluID);

                Bundle bundle = new Bundle();
                bundle.putSerializable("info",infoUser);
                    Intent intent = new Intent(InfoUser.this,solution.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,MY_REQUEST_CODE);
                }

        });
    }

    private void linkview() {
        btn_nextInfo = findViewById(R.id.btn_nextInFo);
        edt_Username = findViewById(R.id.edt_userName);
        edt_Sex = findViewById(R.id.edt_Sex);
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        edt_chest = findViewById(R.id.edt_chest);
        edt_waist = findViewById(R.id.edt_waist);
        edt_hips =findViewById(R.id.edt_hips);
    }
}
