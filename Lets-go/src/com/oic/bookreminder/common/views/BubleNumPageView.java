package com.oic.bookreminder.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 5/24/15.
 */
public class BubleNumPageView extends LinearLayout{
    private View parentView;

    private EditText bubbleNumpage;

    public BubleNumPageView(Context context) {
        super(context);
        inflateLayout();

    }

    public BubleNumPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout();
    }

    public BubleNumPageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateLayout();
    }

    private void inflateLayout(){
        parentView = LayoutInflater.from(getContext()).inflate(R.layout.view_bubble_numpage,null);
        addView(parentView);

        bubbleNumpage = (EditText)parentView.findViewById(R.id.bubbleNumpage);
    }

    public EditText getBubbleNumpage(){
        return bubbleNumpage;
    }
}
