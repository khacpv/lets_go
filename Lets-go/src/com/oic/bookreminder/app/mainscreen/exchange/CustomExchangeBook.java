package com.oic.bookreminder.app.mainscreen.exchange;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomExchangeBook extends RelativeLayout{
    RelativeLayout layout;

    public CustomExchangeBook(Context context) {
        super(context);
        init();
    }

    public CustomExchangeBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomExchangeBook(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.exchange_book,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }
}
