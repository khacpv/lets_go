package com.oic.bookreminder.common.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 5/24/15.
 */
public class ReadBookView extends LinearLayout implements View.OnClickListener {

    private View parentView;

    private View readBookView;
    private View readBookViewComplete;

    private boolean isComplete = false;

    public BubleNumPageView fragmentReadBookNumPage;
    public ClockDigitalView fragmentReadBookClock;

    public ReadBookView(Context context) {
        super(context);
        inflateLayout(null);
    }

    public ReadBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(attrs);
    }

    public ReadBookView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateLayout(attrs);
    }

    @Override
    public void onClick(View v) {
        setComplete(false);
    }

    private void inflateLayout(AttributeSet attr){
        if(null != attr){
            TypedArray a = getContext().obtainStyledAttributes(attr, R.styleable.ReadBookView);
            isComplete = a.getBoolean(R.styleable.ReadBookView_readbook_isComplete,false);
        }
        readBookView = LayoutInflater.from(getContext()).inflate(R.layout.view_read_book,null);
        readBookViewComplete = LayoutInflater.from(getContext()).inflate(R.layout.view_read_book_complete,null);

        parentView = isComplete?readBookViewComplete:readBookView;

        removeAllViews();
        addView(parentView);

        if(!isComplete) {
            fragmentReadBookNumPage = (BubleNumPageView) parentView.findViewById(R.id.fragmentReadBookNumPage);
            fragmentReadBookClock = (ClockDigitalView) parentView.findViewById(R.id.fragmentReadBookClock);
        }else{
            readBookViewComplete.setOnClickListener(this);
        }

        setLayoutTransition(new LayoutTransition());
    }

    public void closeBook(){

    }

    public boolean isComplete(){
        return  isComplete;
    }

    public void setComplete(boolean isComplete){
        this.isComplete = isComplete;
        inflateLayout(null);
    }
}
