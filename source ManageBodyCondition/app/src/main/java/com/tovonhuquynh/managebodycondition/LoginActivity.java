package com.tovonhuquynh.managebodycondition;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.tovonhuquynh.managebodycondition.R.id.btn_signIn;
import static com.tovonhuquynh.managebodycondition.R.id.edt_passwordLogin;
import static com.tovonhuquynh.managebodycondition.R.id.edt_usernameLogin;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edtusenamelogin, edtpasswordlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        linkview();
        addevent();
    }
    public void linkview(){
        btn_login = findViewById(btn_signIn);
        edtusenamelogin = findViewById(edt_usernameLogin);
        edtpasswordlogin= findViewById(R.id.edt_passwordLogin);
    }
    public void addevent(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtusenamelogin.getText().toString();
                String passWord = edtpasswordlogin.getText().toString();
                Cursor cursor = Welcome.database.rawQuery("select * from users where username = '"+userName+"' and password = '"+passWord+"'",null);
                if(cursor.moveToNext()){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("userSignin",userName);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Account or password incorrect!!!",Toast.LENGTH_LONG).show();
                    edtusenamelogin.setText("");
                    edtpasswordlogin.setText("");
                }
                cursor.close();
            }
        });

    }
}
