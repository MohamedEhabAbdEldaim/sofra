package com.midooabdaim.sofra.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.midooabdaim.sofra.R;
import com.midooabdaim.sofra.data.model.General.cityAndRegion.cityAndRegionData;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdpter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    public int itemselected = 0;
    public List<cityAndRegionData> list = new ArrayList<>();

    public SpinnerAdpter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
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
        convertView=layoutInflater.inflate(R.layout.item_spinner,parent,false);
        TextView textView=(TextView)convertView.findViewById(R.id.item_spinner_text_view);
        textView.setText(list.get(position).getName());
        itemselected=list.get(position).getId();
        return convertView;
    }
    public void setData(List<cityAndRegionData> list, String hint){
        this.list=new ArrayList<>();
        this.list.add(new cityAndRegionData(0,hint));
        this.list.addAll(list);
    }
}
