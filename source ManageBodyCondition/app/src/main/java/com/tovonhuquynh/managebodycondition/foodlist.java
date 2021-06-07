package com.tovonhuquynh.managebodycondition;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tovonhuquynh.adapter.adapterfood;
import com.tovonhuquynh.model.food;

import java.util.ArrayList;

public class foodlist extends Fragment {
    TextView txt_dietName;
    ListView listView;
    ArrayList<food> arraylist;
    adapterfood adapter;
    View adview;
    MainActivity mMainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adview = inflater.inflate(R.layout.food,container,false);

        mMainActivity= (MainActivity) getActivity();
        linkview();

        return adview;
    }

    private void linkview() {
        txt_dietName = adview.findViewById(R.id.txt_dietname);
        listView = adview.findViewById(R.id.lv_food);
        arraylist = new ArrayList<>();
        adapter = new adapterfood(getContext(),R.layout.customfood,arraylist);
        listView.setAdapter(adapter);

        String userName = mMainActivity.getuserName();

        Cursor cursorinfo = Welcome.database.rawQuery("select solutionId from infoUser where userName = '"+userName+"' " , null);
        while (cursorinfo.moveToNext()) {
            int soluID = cursorinfo.getInt(0);

            Cursor cursorSolu = Welcome.database.rawQuery("select dietID from solution where solutionID = '" + soluID + "'", null);
            while (cursorSolu.moveToNext()) {
                int dietID = cursorSolu.getInt(0);

                Cursor cursordiet = Welcome.database.rawQuery("select dietname from deits where dietID = '" + dietID + "' ", null);
                while (cursordiet.moveToNext()) {
                    String dietName = cursordiet.getString(0);
                    txt_dietName.setText(dietName);
                }

                Cursor cursor = Welcome.database.rawQuery("select * from dietDetails where dietID = '" + dietID + "' ", null);
                arraylist.clear();
                while (cursor.moveToNext()) {
                    int iddetail = cursor.getInt(0);
                    String listfood = cursor.getString(1);
                    int dietid = cursor.getInt(2);
                    int day = cursor.getInt(3);
                    String mealtime = cursor.getString(4);

                    if (mealtime.equals("Breakfast")) {
                        arraylist.add(new food(iddetail, listfood, dietid, day, mealtime, R.drawable.breakfast));
                    } else if (mealtime.equals("Lunch")) {
                        arraylist.add(new food(iddetail, listfood, dietid, day, mealtime, R.drawable.lunch));
                    } else if (mealtime.equals("Dinner")) {
                        arraylist.add(new food(iddetail, listfood, dietid, day, mealtime, R.drawable.dinner));
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }
    }

}
