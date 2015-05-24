package com.oic.bookreminder.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 5/24/15.
 */
public class BubbleTextView extends LinearLayout {
    public BubbleTextView(Context context) {
        super(context);
        inflateLayout();
    }

    public BubbleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout();
    }

    public BubbleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateLayout();
    }

    private void inflateLayout(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_bubble_text,null);
        addView(view);
    }
}
