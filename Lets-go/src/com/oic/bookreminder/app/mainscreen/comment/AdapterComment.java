package com.oic.bookreminder.app.mainscreen.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.oic.bookreminder.models.tables.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class AdapterComment extends ArrayAdapter{
    List<Comment> comments;

    CustomCommentItem.OnCustomCommentItemClick listener;

    public AdapterComment(Context context, List<Comment> data, CustomCommentItem.OnCustomCommentItemClick listener) {
        super(context, 0);
        this.comments = data;
        this.listener = listener;
    }

    public void setComments(List<Comment> data){
        if(null == comments){
            comments = new ArrayList<>();
        }
        comments.clear();
        comments.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomCommentItem view;
        if(null == convertView){
            convertView = new CustomCommentItem(getContext());
        }
        view = (CustomCommentItem)convertView;
        view.setOnCustomCommentItemClickListener(listener);
        Comment comment = (Comment)getItem(position);
        view.setData(comment);
        return view;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

}
