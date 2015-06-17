package com.oic.bookreminder.app.mainscreen.exchange;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.oic.bookreminder.models.tables.Exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class AdapterExchange extends ArrayAdapter{
    List<Exchange> exchanges;

    public AdapterExchange(Context context, List<Exchange> data) {
        super(context, 0);
        this.exchanges = data;
    }

    public void setExchanges(List<Exchange> data){
        if(null == exchanges){
            exchanges = new ArrayList<>();
        }
        exchanges.clear();
        exchanges.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomExchangeItem view;
        if(null == convertView){
            convertView = new CustomExchangeItem(getContext());
        }
        view = (CustomExchangeItem)convertView;
        Exchange item = (Exchange)getItem(position);
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
        return new Exchange();
    }

}
