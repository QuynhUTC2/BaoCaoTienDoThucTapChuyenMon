package com.tovonhuquynh.managebodycondition;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tovonhuquynh.adapter.adapterExercise;
import com.tovonhuquynh.model.exercise;

import java.util.ArrayList;

public class fitnesslayout extends Fragment {
    TextView txt_exerciseName;
    ListView listView;
    ArrayList<exercise> arraylist;
    adapterExercise adapter;
    View adview;
    MainActivity mMainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adview = inflater.inflate(R.layout.fitness,container,false);
        mMainActivity= (MainActivity) getActivity();
        linkview();
        return adview;
    }
    private void linkview() {
        txt_exerciseName = adview.findViewById(R.id.txt_exerciseName);
        listView = adview.findViewById(R.id.lv_exercise);
        arraylist = new ArrayList<>();
        adapter = new adapterExercise(getContext(),R.layout.custom_exersice,arraylist);
        listView.setAdapter(adapter);

        String userName = mMainActivity.getuserName();

        Cursor cursorinfo = Welcome.database.rawQuery("select solutionId from infoUser where userName = '"+userName+"' " , null);
        while (cursorinfo.moveToNext()) {
            int soluID = cursorinfo.getInt(0);

            Cursor cursorSolu = Welcome.database.rawQuery("select exerciseRegimesID from solution where solutionID = '" + soluID + "'", null);
            while (cursorSolu.moveToNext()) {
                int exRID = cursorSolu.getInt(0);

                Cursor cursorEx = Welcome.database.rawQuery("select eRname from exerciseRegimes where eRID = '" + exRID + "' ", null);
                while (cursorEx.moveToNext()) {
                    String exRName = cursorEx.getString(0);
                    txt_exerciseName.setText(exRName);
                }

                Cursor cursor = Welcome.database.rawQuery("select * from exerciseRegimesdetails where eRID = '" + exRID + "' ", null);
                arraylist.clear();
                while (cursor.moveToNext()) {
                    int iddetail = cursor.getInt(0);
                    String exName = cursor.getString(1);
                    String time = cursor.getString(2);
                    String linkyoutube = cursor.getString(3);
                    int day = cursor.getInt(4);
                    int eRID = cursor.getInt(5);

                    if (exName.equals("Tay") || exName.equals("Lưng")|| exName.equals("Bụng") || exName.equals("Vai") || exName.equals("Ngực") ) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.taylungbungngucvai));
                    } else if (exName.equals("Chân") || exName.equals("Mông")) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.chanmong));
                    } else if (exName.equals("Jumping Jacks")) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.jumpingjack));
                    }else if (exName.equals("Plank")) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.plank));
                    }else if (exName.equals("Moutain climbers")) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.moutainclimper));
                    }else if (exName.equals("Lunge")) {
                        arraylist.add(new exercise(iddetail, exName, time,linkyoutube, day, eRID, R.drawable.lunge));
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getContext(), playvideo.class);
                    startActivity(intent);
                }
            }
        });
    }



}
