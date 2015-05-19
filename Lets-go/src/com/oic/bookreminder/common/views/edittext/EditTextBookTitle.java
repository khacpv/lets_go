package com.oic.bookreminder.common.views.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by khacpham on 5/19/15.
 */
public class EditTextBookTitle extends EditText{
    public EditTextBookTitle(Context context) {
        super(context);
        init();
    }

    public EditTextBookTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextBookTitle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init(){
        try {
            Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/royal_2.ttf");
            setTypeface(font);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
