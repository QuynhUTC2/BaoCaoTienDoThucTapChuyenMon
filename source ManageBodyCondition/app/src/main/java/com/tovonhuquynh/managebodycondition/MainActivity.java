package com.tovonhuquynh.managebodycondition;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView txt_userName;
    String m_userName="";

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
        bottomNavigationView = findViewById(R.id.botton_navigate);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        String userSignin = getIntent().getStringExtra("userSignin");
        String userSignup = getIntent().getStringExtra("userSignup");

        if(userSignin != null){
            txt_userName.setText(userSignin);
        }else if (userSignup != null){
            txt_userName.setText(userSignup);
        }

        String username = txt_userName.getText().toString();
        m_userName = username;

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_viewnavigate,new dashboardlayout()).commit();

    }

    public String getuserName() {
        return m_userName;
    }

}