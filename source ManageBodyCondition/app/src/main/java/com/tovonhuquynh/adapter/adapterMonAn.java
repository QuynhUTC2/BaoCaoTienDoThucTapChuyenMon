package com.tovonhuquynh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tovonhuquynh.managebodycondition.R;
import com.tovonhuquynh.model.MonAn;

import java.util.List;

public class adapterMonAn extends BaseAdapter {
    private Context contextMonAn;
    private int layoutMonAn;
    private List<MonAn> ListMonAn;

    public adapterMonAn(Context contextMonAn, int layoutMonAn, List<MonAn> listMonAn) {
        this.contextMonAn = contextMonAn;
        this.layoutMonAn = layoutMonAn;
        ListMonAn = listMonAn;
    }

    @Override
    public int getCount() {
        return ListMonAn.size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutMonAn,parent,false);
            holder.txt_monan= convertView.findViewById(R.id.txt_monan);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        final MonAn e = ListMonAn.get(position);
        holder.txt_monan.setText(e.getTenmonan());

        return convertView;
    }

    private static class ViewHolder{
        TextView txt_monan;
    }

}
