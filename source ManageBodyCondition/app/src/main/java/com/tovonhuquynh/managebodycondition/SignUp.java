package com.tovonhuquynh.managebodycondition;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    Button btn_Signup;
    EditText edt_userName, edt_pass,edt_passAgain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        linkview();
        addevent();
    }
    public void linkview(){
        btn_Signup = findViewById(R.id.btn_signUp);
        edt_userName = findViewById(R.id.edt_userNameSignup);
        edt_pass = findViewById(R.id.edt_passSignup);
        edt_passAgain = findViewById(R.id.edt_passSignupAgain);
    }
    public void addevent(){
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                String userName = edt_userName.getText().toString();
                String passWord = edt_pass.getText().toString();
                String passWordAgain = edt_passAgain.getText().toString();

                Cursor cursor = Welcome.database.rawQuery("select * from users where username = '"+userName+"'",null);
                if(cursor.moveToNext()){
                    edt_userName.setText("");
                    edt_userName.setHint("Tài khoản đã tồn tại!! ");
                    edt_userName.setHintTextColor(R.color.red);
                }else {
                    if(passWord.length()<8){
                        edt_pass.setText("");
                        edt_pass.setHint("Password phai tu 8 chu so!");
                        edt_pass.setHintTextColor(R.color.red);
                    }else {
                        if(passWord.equals(passWordAgain)){
                            ContentValues values = new ContentValues();
                            values.put("username", userName);
                            values.put("password",passWord);

                            long flag =Welcome.database.insert("users",null,values);
                            if (flag>0){
                                Toast.makeText(SignUp.this,"Add user successful!",Toast.LENGTH_LONG);
                            }else{
                                Toast.makeText(SignUp.this,"FAIL!!!!",Toast.LENGTH_LONG);
                            }
                            Intent intent = new Intent(SignUp.this,InfoUser.class);
                            intent.putExtra("userSinup",userName);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp.this,"password again khong trung khop!!",Toast.LENGTH_LONG).show();
                            edt_passAgain.setText("");
                        }
                    }
                }

            }
        });
    }
}
