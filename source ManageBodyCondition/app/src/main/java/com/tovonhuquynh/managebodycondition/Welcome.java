package com.tovonhuquynh.managebodycondition;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Welcome extends AppCompatActivity {
    public static final String DATABASE_NAME = "MBC.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database = null;
    Button btn_signupW,btn_signinW;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        copyDataBase();
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE,null);
        btn_signupW = findViewById(R.id.btn_signUpW);
        btn_signinW = findViewById(R.id.btn_signInW);

        btn_signupW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this,SignUp.class);
                startActivity(intent);
            }
        });
        btn_signinW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void copyDataBase() {
        try {
            File dbfile = getDatabasePath(DATABASE_NAME);
            if (!dbfile.exists()) {
                if (CopyDBFromAsset()) {
                    Toast.makeText(Welcome.this, "Copy database successful!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Welcome.this, "Copy database fails!", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            Log.e("Error:", e.toString());
        }
    }

    private boolean CopyDBFromAsset() {
        String dbPath = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
        try {
            InputStream inputStream = getAssets().open(DATABASE_NAME);
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

