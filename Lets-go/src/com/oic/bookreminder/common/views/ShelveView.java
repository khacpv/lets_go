package com.oic.bookreminder.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 5/24/15.
 */
public class ShelveView extends LinearLayout{
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_1 = 1;
    public static final int STYLE_2 = 2;
    public static final int STYLE_3 = 3;
    public static final int STYLE_4 = 4;
    public static final int STYLE_5 = 5;

    private int style = 0;

    private View parentView;
    private ImageView shelve1;
    private ImageView shelve2;
    private ImageView shelve3;

    public ShelveView(Context context) {
        super(context);
        inflateLayout(null);
    }

    public ShelveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout(attrs);
    }

    public ShelveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateLayout(attrs);
    }

    private void inflateLayout(AttributeSet attr){
        this.parentView = LayoutInflater.from(getContext()).inflate(R.layout.view_shelve_book,null);
        addView(parentView);

        shelve1 = (ImageView)parentView.findViewById(R.id.shelve1);
        shelve2 = (ImageView)parentView.findViewById(R.id.shelve2);
        shelve3 = (ImageView)parentView.findViewById(R.id.shelve3);

        if(null != attr){
            TypedArray a = getContext().obtainStyledAttributes(attr, R.styleable.ShelveView);
            style = a.getInt(R.styleable.ShelveView_shelve_style,STYLE_DEFAULT);

        }

        setStyle(style);
    }

    public void setStyle(int style){
        this.style = (style<0 || style > STYLE_5)? STYLE_DEFAULT: style;
        switch (this.style){
            case STYLE_1:
                shelve1.setImageResource(R.drawable.ic_reading_lib1);
                shelve2.setImageResource(R.drawable.ic_reading_lib3);
                shelve3.setImageResource(R.drawable.ic_reading_lib2);
                break;
            case STYLE_2:
                shelve1.setImageResource(R.drawable.ic_reading_lib2);
                shelve2.setImageResource(R.drawable.ic_reading_lib1);
                shelve3.setImageResource(R.drawable.ic_reading_lib3);
                break;
            case STYLE_3:
                shelve1.setImageResource(R.drawable.ic_reading_lib2);
                shelve2.setImageResource(R.drawable.ic_reading_lib3);
                shelve3.setImageResource(R.drawable.ic_reading_lib1);
                break;
            case STYLE_4:
                shelve1.setImageResource(R.drawable.ic_reading_lib3);
                shelve2.setImageResource(R.drawable.ic_reading_lib1);
                shelve3.setImageResource(R.drawable.ic_reading_lib2);
                break;
            case STYLE_5:
                shelve1.setImageResource(R.drawable.ic_reading_lib3);
                shelve2.setImageResource(R.drawable.ic_reading_lib2);
                shelve3.setImageResource(R.drawable.ic_reading_lib1);
                break;
            default:
                shelve1.setImageResource(R.drawable.ic_reading_lib1);
                shelve2.setImageResource(R.drawable.ic_reading_lib2);
                shelve3.setImageResource(R.drawable.ic_reading_lib3);
                break;
        }
    }
}
