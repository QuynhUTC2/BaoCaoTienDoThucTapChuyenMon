package com.tovonhuquynh.managebodycondition;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tovonhuquynh.model.InfoUser;

public class solution extends AppCompatActivity {
    Button btn_giamcan,btn_suckhoe,btn_tangcan;
    TextView txt_advice;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution);

        linkview();
        addevent();
    }

    private void addevent() {
        btn_giamcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loaddata(1);
                Intent intent = new Intent(solution.this,MainActivity.class);
                intent.putExtra("userSignup",userName);
                startActivity(intent);
            }
        });
        btn_suckhoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loaddata(2);
                Intent intent = new Intent(solution.this,MainActivity.class);
                intent.putExtra("userSignup",userName);
                startActivity(intent);
            }
        });
        btn_tangcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loaddata(3);
                Intent intent = new Intent(solution.this,MainActivity.class);
                intent.putExtra("userSignup",userName);
                startActivity(intent);
            }
        });
    }

    private String loaddata(int solutionid){

        InfoUser infoUser = (InfoUser) getIntent().getExtras().get("info");
        String userName = infoUser.getUserName();
        String Sex = infoUser.getSex();
        Double height = infoUser.getHeight();
        Double weight = infoUser.getWeight();
        Double chest = infoUser.getChest();
        Double waist = infoUser.getWaist();
        Double hips = infoUser.getHips();

        ContentValues values = new ContentValues();
        values.put("sex", Sex);
        values.put("height",height);
        values.put("weight",weight);
        values.put("chest",chest);
        values.put("waist",waist);
        values.put("hips",hips);
        values.put("userName",userName);
        values.put("solutionID",solutionid);
        long flag =Welcome.database.insert("infoUser",null,values);
        if (flag>0){
            Toast.makeText(solution.this,"Add infouser successful!",Toast.LENGTH_LONG);
        }else{
            Toast.makeText(solution.this,"FAIL!!!!",Toast.LENGTH_LONG);
        }
        return userName;
    }

    private void linkview() {
        btn_giamcan = findViewById(R.id.btn_solution_GiamCan);
        btn_suckhoe = findViewById(R.id.btn_solution_Suckhoe);
        btn_tangcan = findViewById(R.id.btn_solution_TangCan);
        txt_advice = findViewById(R.id.txt_advice);

        InfoUser infoUser = (InfoUser) getIntent().getExtras().get("info");
        Double height = infoUser.getHeight();
        Double weight = infoUser.getWeight();

        double BMIshow = Math.round(weight/(height*height)*100)/100;
        if(BMIshow < 18.5){
            txt_advice.setText("C??n n???ng c???a b???n kh?? th???p so v???i chi???u cao "+height+", h??y ch???n solution t??ng c??n ????? c?? th??n h??nh v?? s???c kh???e t???t h??n.");
        }else if (18.5 <= BMIshow && BMIshow <= 22.9){
            txt_advice.setText("Ch??c m???ng b???n! B???n c?? th??n h??nh c??n ?????i h??y ch???n solution t??ng s???c kh???e ????? duy tr?? s???c kh???e th???t t???t nh??.");
        }
        else if (23 <= BMIshow && BMIshow <= 24.9){
            txt_advice.setText("C??n n???ng c???a b???n kh?? cao so v???i chi???u cao "+height+", h??y ch???n solution gi???m c??n ????? c?? th??n h??nh v?? s???c kh???e t???t h??n.");
        }
        else if (25 <= BMIshow && BMIshow <= 29.9){
            txt_advice.setText("C??n n???ng c???a b???n cao so v???i chi???u cao "+height+", h??y ch???n solution gi???m c??n ????? c?? th??n h??nh v?? s???c kh???e t???t h??n.");
        }
        else if (30 <= BMIshow ){
            txt_advice.setText("C??n n???ng c???a b???n qu?? so v???i chi???u cao "+height+", s???c kh???e ??ang ??? m???c b??o ?????ng n??n ch???n solution gi???m c??n ????? c?? th??n h??nh v?? s???c kh???e t???t h??n.");
        }
    }
}
