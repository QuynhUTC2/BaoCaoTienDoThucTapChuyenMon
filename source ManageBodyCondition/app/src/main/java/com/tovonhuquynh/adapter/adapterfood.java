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
import com.tovonhuquynh.managebodycondition.R;
import com.tovonhuquynh.managebodycondition.monangoiy;
import com.tovonhuquynh.model.food;

import java.util.List;

public class adapterfood extends BaseAdapter {

    private Context context;
    private int layout;
    private List<food> foodList;

    public adapterfood(Context context, int layout, List<food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
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
            convertView = LayoutInflater.from(context).inflate(layout,parent,false);
            holder.txt_meal= convertView.findViewById(R.id.txt_meal);
            holder.txt_day = convertView.findViewById(R.id.txt_day);
            holder.txt_foodlist = convertView.findViewById(R.id.txt_foodlist);
            holder.img_food = convertView.findViewById(R.id.img_food);
            holder.btn_goiy = convertView.findViewById(R.id.btn_goiy);
            holder.ckb_foodfinsh = convertView.findViewById(R.id.ckb_checkfood);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        final food f = foodList.get(position);
        holder.txt_meal.setText(f.getMealtime());
        holder.txt_day.setText("Ngày " + String.valueOf(f.getDay()));
        holder.txt_foodlist.setText(f.getFoodname());
        holder.img_food.setImageResource(f.getImgfood());
        holder.btn_goiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, monangoiy.class);
                context.startActivity(intent);
            }
        });
        holder.ckb_foodfinsh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(context,"Bạn đã hoàn thành bữa ăn.",Toast.LENGTH_LONG).show();
                    if(f.getDay()== 3 && f.getMealtime().equals("Dinner")){
                        Intent intent = new Intent(context, InfoUser.class);
                        context.startActivity(intent);
                    }
                }
            }
        });
        return convertView;
    }

    private static class ViewHolder{
        TextView txt_meal, txt_day, txt_foodlist;
        ImageView img_food;
        Button btn_goiy;
        CheckBox ckb_foodfinsh;
    }
}
