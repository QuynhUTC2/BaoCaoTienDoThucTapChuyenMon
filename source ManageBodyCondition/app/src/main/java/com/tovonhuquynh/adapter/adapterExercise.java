package com.tovonhuquynh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tovonhuquynh.managebodycondition.InfoUser;
import com.tovonhuquynh.managebodycondition.playvideo;
import com.tovonhuquynh.managebodycondition.R;
import com.tovonhuquynh.model.exercise;

import java.util.List;

public class adapterExercise extends BaseAdapter {
    private Context contextex;
    private int layoutex;
    private List<exercise> exerciseList;

    public adapterExercise(Context contextex, int layoutex, List<exercise> exerciseList) {
        this.contextex = contextex;
        this.layoutex = layoutex;
        this.exerciseList = exerciseList;
    }

    @Override
    public int getCount() {
        return exerciseList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutex,parent,false);
            holder.txt_exercise= convertView.findViewById(R.id.txt_exercise);
            holder.txt_day = convertView.findViewById(R.id.txt_dayex);
            holder.txt_time = convertView.findViewById(R.id.txt_time);
            holder.img_exercise = convertView.findViewById(R.id.img_exersice);
            holder.btn_watchvideo = convertView.findViewById(R.id.btn_watchvideo);
            holder.checkFinish = convertView.findViewById(R.id.ckb_checkexercise);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        final exercise e = exerciseList.get(position);
        holder.txt_exercise.setText(e.getExName());
        holder.txt_day.setText("Ngày " + String.valueOf(e.getDay()));
        holder.txt_time.setText(e.getTime());
        holder.img_exercise.setImageResource(e.getImg_ex());
        holder.btn_watchvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(contextex,playvideo.class);
                contextex.startActivity(intent);
            }
        });
        holder.checkFinish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(contextex,"Bạn đã hoàn thành bài tập",Toast.LENGTH_LONG).show();
                    if(e.getExID() == exerciseList.size()){
                        Intent intent = new Intent(contextex, InfoUser.class);
                        contextex.startActivity(intent);
                    }
                }
            }
        });
        return convertView;
    }

    private static class ViewHolder{
        TextView txt_exercise, txt_day, txt_time;
        ImageView img_exercise;
        Button btn_watchvideo;
        CheckBox checkFinish;
    }
}
