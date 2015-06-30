package com.oic.bookreminder.app.mainscreen.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomCommentSearchItem extends RelativeLayout{
    RelativeLayout layout;

    public CustomCommentSearchItem(Context context) {
        super(context);
        init();
    }

    public CustomCommentSearchItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCommentSearchItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        try {
            layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.comment_search_item, null);
            addView(layout);
            ButterKnife.inject(this);

            initDefaultData();
        }catch (Exception e){

        }
    }

    private void initDefaultData(){

    }
}
