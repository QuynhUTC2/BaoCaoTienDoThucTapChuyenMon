package com.tovonhuquynh.managebodycondition;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tovonhuquynh.adapter.adapterMonAn;
import com.tovonhuquynh.model.MonAn;

import java.util.ArrayList;

public class monangoiy extends AppCompatActivity {
    Button btn_quit;
    ListView listView;
    ArrayList<MonAn> arraylist;
    adapterMonAn adapter;
    String mealtime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_monangoiy);
        linkview();
        addevent();
    }

    private void addevent() {
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void linkview() {
        btn_quit = findViewById(R.id.btn_quitgoiy);

        String buaan = getIntent().getStringExtra("buaan");
        if (buaan.equals("Bữa sáng")){
            mealtime = "Breakfast";
        }else if (buaan.equals("Bữa trưa")){
            mealtime = "Lunch";
        }else if (buaan.equals("Bữa tối")){
            mealtime = "Dinner";
        }
        listView = findViewById(R.id.lv_monan);
        arraylist = new ArrayList<>();
        adapter = new adapterMonAn(getApplicationContext(),R.layout.custom_listmonan,arraylist);
        listView.setAdapter(adapter);

        Cursor cursor = Welcome.database.rawQuery("select * from MonAn where mealTime = '" +mealtime+ "' ", null);
        arraylist.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String tenmonan = cursor.getString(1);
            String tenfood = cursor.getString(2);
            arraylist.add(new MonAn(id,tenmonan,tenfood));

        }
        adapter.notifyDataSetChanged();

    }
}
