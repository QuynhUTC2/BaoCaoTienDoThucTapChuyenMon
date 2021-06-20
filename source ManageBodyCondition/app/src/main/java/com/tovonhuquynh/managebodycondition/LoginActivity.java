package com.tovonhuquynh.managebodycondition;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.tovonhuquynh.managebodycondition.R.id.btn_signIn;
import static com.tovonhuquynh.managebodycondition.R.id.edt_usernameLogin;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edtusenamelogin, edtpasswordlogin;
    TextView txt_quenmk, txt_dangky;

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
        txt_quenmk = findViewById(R.id.txt_QuenMK);
        txt_dangky = findViewById(R.id.txt_dangky);
    }
    public void addevent(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String userName = edtusenamelogin.getText().toString();
                String passWord = edtpasswordlogin.getText().toString();
                if(userName.equals("") ){
                    edtusenamelogin.setHint("Hãy nhập tên tài khoản!!");
                    edtusenamelogin.setHintTextColor(R.color.ogrange);
                }else if(passWord.equals("")){
                    edtpasswordlogin.setHint("Hãy nhập tên mật khẩu!!");
                    edtpasswordlogin.setHintTextColor(R.color.ogrange);
                } else {
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

            }
        });
        txt_quenmk.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String userName = edtusenamelogin.getText().toString();
                if(userName.equals("")){
                    edtusenamelogin.setHint("Hãy nhập tên tài khoản!!");
                    edtusenamelogin.setHintTextColor(R.color.ogrange);
                }else {
                    String userName2 = edtusenamelogin.getText().toString();
                    Cursor cursor = Welcome.database.rawQuery("select password from users where username = '"+userName2+"' ",null);
                    if (cursor.moveToNext()){
                        String pass = cursor.getString(0);
                        Toast.makeText(LoginActivity.this, "Hãy thử nhập "+ pass + " đó là mật khẩu của bạn.", Toast.LENGTH_LONG).show();

                    }else {
                        edtusenamelogin.setText("");
                        edtusenamelogin.setHint("Tài khoản không tồn tại!! ");
                        edtusenamelogin.setHintTextColor(R.color.red);
                    }
                    cursor.close();
                }
            }
        });
        txt_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

    }
}
