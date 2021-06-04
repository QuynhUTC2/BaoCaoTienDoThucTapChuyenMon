package com.tovonhuquynh.managebodycondition;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tovonhuquynh.adapter.adapterfood;
import com.tovonhuquynh.model.food;

import java.util.ArrayList;
import java.util.List;

public class foodlist extends Fragment {
    ListView listView;
    List<food> arraylist;

    View adview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adview = inflater.inflate(R.layout.food,container,false);

        linkview();

        return adview;
    }

    private void linkview() {

        listView = adview.findViewById(R.id.lv_food);
        arraylist = new ArrayList<>();

        Cursor cursor = Welcome.database.rawQuery("select * from dietDetails " , null);

        while (cursor.moveToNext()) {
            int iddetail = cursor.getInt(0);
            String listfood = cursor.getString(1);
            int diet = cursor.getInt(2);
            int day = cursor.getInt(3);
            String mealtime = cursor.getString(4);
            arraylist.add(new food(iddetail,listfood,diet,day,mealtime));
        }

        adapterfood adapter = new adapterfood(getContext(),R.layout.customfood,arraylist);
        listView.setAdapter(adapter);
    }

}
