package com.oic.bookreminder.app.mainscreen.ask;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.oic.bookreminder.models.tables.Ask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class AdapterAsk extends ArrayAdapter{
    List<Ask> asks;

    public AdapterAsk(Context context, List<Ask> data) {
        super(context, 0);
        this.asks = data;
    }

    public void setAsks(List<Ask> data){
        if(null == asks){
            asks = new ArrayList<>();
        }
        asks.clear();
        asks.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomAskItem view;
        if(null == convertView){
            convertView = new CustomAskItem(getContext());
        }
        view = (CustomAskItem)convertView;
        Ask item = (Ask)getItem(position);
        view.setData(item);
        return view;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return new Ask();
    }

}
