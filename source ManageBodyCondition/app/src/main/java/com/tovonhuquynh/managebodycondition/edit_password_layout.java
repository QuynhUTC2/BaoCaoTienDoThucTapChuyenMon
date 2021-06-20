package com.tovonhuquynh.managebodycondition;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class edit_password_layout extends AppCompatActivity {
    TextView txt_username;
    EditText edt_pass, edt_passagain;
    Button btn_change;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edt_password);
        linkview();

    }

    private void linkview() {
        txt_username = findViewById(R.id.txt_userNameedtpass);
        edt_pass = findViewById(R.id.edt_passedit);
        edt_passagain = findViewById(R.id.edt_passeditAgain);
        btn_change = findViewById(R.id.btn_change);

        String usename = getIntent().getStringExtra("usernamechange");

        txt_username.setText(usename);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String userName = txt_username.getText().toString();
                String passWord = edt_pass.getText().toString();
                String passWordAgain = edt_passagain.getText().toString();

                if(passWord == null){
                    edt_pass.setHint("Hãy nhập mật khẩu!");
                    edt_pass.setHintTextColor(R.color.ogrange);
                }else if (passWordAgain == null){
                    edt_passagain.setHint("Hãy nhập lại mật khẩu!");
                    edt_passagain.setHintTextColor(R.color.ogrange);
                }else {
                    if(passWord.length()<8){
                        edt_pass.setText("");
                        edt_pass.setHint("Password phai tu 8 chu so!");
                        edt_pass.setHintTextColor(R.color.red);
                    }else {
                        if(passWord.equals(passWordAgain)){

                            Cursor cursor =Welcome.database.rawQuery("update users set password = '"+passWord+"' where username = '"+userName+"'",null);

                            finish();
                        }else {
                            Toast.makeText(edit_password_layout.this,"password again khong trung khop!!",Toast.LENGTH_LONG).show();
                            edt_passagain.setText("");
                        }
                    }
                }

            }

        });
    }
}
