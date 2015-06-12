package com.oic.bookreminder.common.views.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;
import com.oic.bookreminder.common.utils.LogUtils;

/**
 * Created by khacpham on 6/12/15.
 */
public class HtmlTextView extends TextView {
    int[] attrsArray = new int[] {
        android.R.attr.text
    };

    public HtmlTextView(Context context) {
        super(context);
        initial(context, null);
    }

    public HtmlTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initial(context,attrs);
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initial(context,attrs);
    }

    private void initial(Context ctx,AttributeSet attrs){
        if(null != attrs){
            TypedArray typedArray = ctx.obtainStyledAttributes(attrs,attrsArray);
            String text = typedArray.getString(0);
            setText(Html.fromHtml(text));
            LogUtils.logE(text);
        }
    }
}
