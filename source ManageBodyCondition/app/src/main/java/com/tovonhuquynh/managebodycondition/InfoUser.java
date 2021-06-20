package com.tovonhuquynh.managebodycondition;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoUser extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 1;
    Button btn_nextInfo;
    EditText  edt_height, edt_weight, edt_chest, edt_waist, edt_hips;
    TextView txt_usename;
    private Spinner spinner;
    private List<String> list;
    static String sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infouser);

        linkview();

    }

    private void linkview() {
        btn_nextInfo = findViewById(R.id.btn_nextInFo);
        txt_usename = findViewById(R.id.txt_userNameinfo);

        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        edt_chest = findViewById(R.id.edt_chest);
        edt_waist = findViewById(R.id.edt_waist);
        edt_hips =findViewById(R.id.edt_hips);

        String username = getIntent().getStringExtra("userSinup");
        String usernameEdit = getIntent().getStringExtra("usernamechange2");

        if(usernameEdit != null){
            txt_usename.setText(usernameEdit);
            Cursor cursor = Welcome.database.rawQuery("select * from infoUser where userName = '"+usernameEdit+"' " , null);
            while (cursor.moveToNext()) {
                int iduser = cursor.getInt(0);
                String sexshow = cursor.getString(1);
                double heightshow = cursor.getDouble(2);
                double weightshow = cursor.getDouble(3);
                double chestshow = cursor.getDouble(4);
                double waistshow = cursor.getDouble(5);
                double hipsshow = cursor.getDouble(6);
                String usernameedt = cursor.getString(7);
                int soluID = cursor.getInt(8);
                com.tovonhuquynh.model.InfoUser infoUser = new com.tovonhuquynh.model.InfoUser(iduser, sexshow, heightshow, weightshow, chestshow, waistshow, hipsshow, usernameedt, soluID);

                edt_height.setText(String.valueOf(infoUser.getHeight()));
                edt_weight.setText(String.valueOf(infoUser.getWeight()));
                edt_chest.setText(String.valueOf(infoUser.getChest()));
                edt_waist.setText(String.valueOf(infoUser.getWaist()));
                edt_hips.setText(String.valueOf(infoUser.getHips()));
            }
        }else if(username != null){
            txt_usename.setText(username);
        }

        list = new ArrayList<>();
        list.add("Nam");
        list.add("Nữ");
        spinner = findViewById(R.id.edt_Sex);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = list.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(InfoUser.this, "onNothingSelected", Toast.LENGTH_SHORT);
            }
        });

            btn_nextInfo.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {

                        int iduser = 0;
                        String userName = txt_usename.getText().toString();
                        String Sex = sex;
                        double height = Double.parseDouble(edt_height.getText().toString());
                        double weight = Double.parseDouble(edt_weight.getText().toString());
                        double chest = Double.parseDouble(edt_chest.getText().toString());
                        double waist = Double.parseDouble(edt_waist.getText().toString());
                        double hips = Double.parseDouble(edt_hips.getText().toString());
                        int soluID = 0;

                        com.tovonhuquynh.model.InfoUser infoUser = new com.tovonhuquynh.model.InfoUser(iduser, Sex, height, weight, chest, waist, hips, userName, soluID);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("info", infoUser);
                        Intent intent = new Intent(InfoUser.this, solution.class);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, MY_REQUEST_CODE);
                    }
            });

    }
}
