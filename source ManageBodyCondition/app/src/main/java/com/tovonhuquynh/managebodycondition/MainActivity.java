package com.tovonhuquynh.managebodycondition;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView txt_userName;
    String m_userName="";
    String m_solutionID ="" ;
    de.hdodenhof.circleimageview.CircleImageView img_avt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkview();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment =null;
                    switch (item.getItemId()) {
                        case R.id.mn_dashboard:
                            selectFragment = new dashboardlayout();
                            break;
                        case R.id.mn_food:
                            selectFragment = new foodlist();
                            break;
                        case R.id.mn_fitness:
                            selectFragment = new fitnesslayout();
                            break;
                        case R.id.mn_track:
                            selectFragment = new tracklayout();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_viewnavigate, selectFragment).commit();
                    return true;
                }
            };

    private void linkview() {
        txt_userName = findViewById(R.id.txt_username);
        img_avt = findViewById(R.id.img_avt);
        bottomNavigationView = findViewById(R.id.botton_navigate);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        String userSignin = getIntent().getStringExtra("userSignin");
        String userSignup = getIntent().getStringExtra("userSignup");

        String solutionID = getIntent().getStringExtra("soluID");
        m_solutionID = solutionID;

        if(userSignin != null){
            txt_userName.setText(userSignin);
        }else if (userSignup != null){
            txt_userName.setText(userSignup);
        }

        String username = txt_userName.getText().toString();
        m_userName = username;

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_viewnavigate,new dashboardlayout()).commit();

        img_avt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,edit_layout.class);
                intent.putExtra("edtusername",username);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public String getuserName() {
        return m_userName;
    }

    public String getM_solutionID() {
        return m_solutionID;
    }
}