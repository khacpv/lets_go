package com.oic.bookreminder.app.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.oic.bookreminder.R;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/29/15.
 */
public class AdapterReview extends BaseAdapter{
    Context ctx;
    ArrayList<String> lstReview;

    public AdapterReview(Context ctx,ArrayList<String> lstReview){
        this.ctx = ctx;
        this.lstReview = lstReview;
    }

    @Override
    public int getCount() {
        return lstReview.size();
    }

    @Override
    public Object getItem(int position) {
        return lstReview.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(null == view){
            view = LayoutInflater.from(ctx).inflate(R.layout.view_review,null);
            ViewHolder holder = new ViewHolder(view);
            view.setTag(holder);
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        holder.textView.setText(lstReview.get(position));
        return view;
    }

    public static class ViewHolder{
        TextView textView;

        public ViewHolder(View parent){
            textView = (TextView)parent.findViewById(R.id.text);
        }
    }
}
