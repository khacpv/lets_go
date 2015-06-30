package com.oic.bookreminder.app.mainscreen.suggest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.oic.bookreminder.models.tables.Suggest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class AdapterSuggest extends ArrayAdapter{
    List<Suggest> asks;

    public AdapterSuggest(Context context, List<Suggest> data) {
        super(context, 0);
        this.asks = data;
    }

    public void setAsks(List<Suggest> data){
        if(null == asks){
            asks = new ArrayList<>();
        }
        asks.clear();
        asks.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomSuggestItem view;
        if(null == convertView){
            convertView = new CustomSuggestItem(getContext());
        }
        view = (CustomSuggestItem)convertView;
        Suggest item = (Suggest)getItem(position);
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
        return new Suggest();
    }

}
