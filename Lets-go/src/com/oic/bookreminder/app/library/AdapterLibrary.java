package com.oic.bookreminder.app.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.oic.bookreminder.R;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/30/15.
 */
public class AdapterLibrary extends BaseAdapter {

    Context ctx;
    ArrayList<String> lstReview;

    public AdapterLibrary(Context ctx,ArrayList<String> lstReview){
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
            view = LayoutInflater.from(ctx).inflate(R.layout.view_book,null);
            ViewHolder holder = new ViewHolder(view);
            view.setTag(holder);
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        holder.title.setText(lstReview.get(position));
        return view;
    }

    public static class ViewHolder{
        TextView title;
        TextView author;

        public ViewHolder(View parent){
            title = (TextView)parent.findViewById(R.id.title);
            author = (TextView)parent.findViewById(R.id.author);
        }
    }
}