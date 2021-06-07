package com.tovonhuquynh.managebodycondition;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;

public class edit_layout extends AppCompatActivity {
    Button btn_editpassword, btn_edtInfouser, btn_logout;
    TextView txt_editname;
    ImageView img_avtedit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_infor_layout);

        linkview();
    }

    private void linkview() {
        img_avtedit = findViewById(R.id.img_avtedit);
        btn_editpassword = findViewById(R.id.btn_edtpassword);
        btn_edtInfouser = findViewById(R.id.btn_editInfo);
        btn_logout = findViewById(R.id.btn_logout);
        txt_editname = findViewById(R.id.txt_Nameedit);

        String username = getIntent().getStringExtra("edtusername");
        txt_editname.setText(username);
        btn_editpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_layout.this,edit_password_layout.class);
                intent.putExtra("usernamechange",username);
                startActivity(intent);
            }
        });
        btn_edtInfouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_layout.this,InfoUser.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_layout.this,Welcome.class);
                startActivity(intent);
            }
        });
        img_avtedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestpermission();
            }
        });
    }

    private void requestpermission(){
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openImagePicker();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(edit_layout.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };
        TedPermission.with(edit_layout.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }
    private void openImagePicker(){
        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
            @Override
            public void onImageSelected(Uri uri) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    img_avtedit.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(edit_layout.this)
                .setOnImageSelectedListener(listener)
                .create();
        tedBottomPicker.show(getSupportFragmentManager());
    }
}
