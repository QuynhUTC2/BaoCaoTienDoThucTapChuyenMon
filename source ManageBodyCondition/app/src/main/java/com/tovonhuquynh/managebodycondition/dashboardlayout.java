package com.tovonhuquynh.managebodycondition;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tovonhuquynh.model.InfoUser;

public class dashboardlayout extends Fragment {

   TextView txt_BMI,txt_height,txt_weight,txt_chest,txt_waist,txt_hips;
   ImageView img_body,img_height;
    View adview;
    MainActivity mMainActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adview = inflater.inflate(R.layout.dashboard,container,false);

        mMainActivity= (MainActivity) getActivity();
        linkview();

        return adview;
    }

    @SuppressLint("ResourceAsColor")
    private void linkview() {
        txt_BMI = adview.findViewById(R.id.txt_BMI);
        img_body = adview.findViewById(R.id.imgview_body);
        img_height = adview.findViewById(R.id.img_height);
        txt_height = adview.findViewById(R.id.txt_height);
        txt_weight = adview.findViewById(R.id.txt_weight);
        txt_chest = adview.findViewById(R.id.txt_chest);
        txt_waist = adview.findViewById(R.id.txt_waist);
        txt_hips = adview.findViewById(R.id.txt_hips);


        String userName = mMainActivity.getuserName();

        Cursor cursor = Welcome.database.rawQuery("select * from infoUser where userName = '"+userName+"' " , null);
        while (cursor.moveToNext()) {
            int iduser = cursor.getInt(0);
            String sexshow = cursor.getString(1);
            double heightshow = cursor.getDouble(2);
            double weightshow = cursor.getDouble(3);
            double chestshow = cursor.getDouble(4);
            double waistshow = cursor.getDouble(5);
            double hipsshow = cursor.getDouble(6);
            String username = cursor.getString(7);
            int soluID = cursor.getInt(8);
            InfoUser infoUser = new InfoUser(iduser, sexshow, heightshow, weightshow, chestshow, waistshow, hipsshow, username,soluID);


            double BMIshow = Math.round(infoUser.getWeight()/(infoUser.getHeight()*infoUser.getHeight())*100)/100;
            if(BMIshow < 18.5){
                txt_BMI.setText(String.valueOf(BMIshow) + " Gầy ");
                txt_BMI.setTextColor(R.color.purple_200);
            }else if (18.5 <= BMIshow && BMIshow <= 22.9){
                txt_BMI.setText(String.valueOf(BMIshow) + " Cân đối ");
                txt_BMI.setTextColor(R.color.green);
            }
            else if (23 <= BMIshow && BMIshow <= 24.9){
                txt_BMI.setText(String.valueOf(BMIshow) + " Thừa cân");
                txt_BMI.setTextColor(R.color.yellow);
            }
            else if (25 <= BMIshow && BMIshow <= 29.9){
                txt_BMI.setText(String.valueOf(BMIshow) + " Béo");
                txt_BMI.setTextColor(R.color.ogrange);
            }
            else if (30 <= BMIshow ){
                txt_BMI.setText(String.valueOf(BMIshow) + " Béo phì");
                txt_BMI.setTextColor(R.color.red);
            }

            String sexuser = String.valueOf(infoUser.getSex());
            if(sexuser.equals("boy")){
                img_body.setImageResource(R.drawable.fullbodyboy);
            }
            if (sexuser.equals("girl")){
                img_height.setImageResource(R.drawable.heightgirl);
            }

            txt_height.setText(String.valueOf(infoUser.getHeight()) + "m");
            txt_weight.setText(String.valueOf(infoUser.getWeight()) + "kg");
            txt_chest.setText(String.valueOf(infoUser.getChest()) + "cm");
            txt_waist.setText(String.valueOf(infoUser.getWaist()) + "cm");
            txt_hips.setText(String.valueOf(infoUser.getHips()) + "cm");


        }
    }


}
