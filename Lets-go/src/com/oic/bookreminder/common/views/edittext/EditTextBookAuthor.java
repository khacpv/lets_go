package com.oic.bookreminder.common.views.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by khacpham on 5/19/15.
 */
public class EditTextBookAuthor extends EditTextBookTitle{
    public EditTextBookAuthor(Context context) {
        super(context);
    }

    public EditTextBookAuthor(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextBookAuthor(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        try {
            Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/royal_2.ttf");
            setTypeface(font);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
