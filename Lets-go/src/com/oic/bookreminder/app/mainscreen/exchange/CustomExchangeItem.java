package com.oic.bookreminder.app.mainscreen.exchange;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.tables.Exchange;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomExchangeItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvExchangeTitle)
    TextView tvExchangeTitle;

    public CustomExchangeItem(Context context) {
        super(context);
        init();
    }

    public CustomExchangeItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomExchangeItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_exchange_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    public void setData(Exchange exchange){
        TextFormat.setCommentTitleText(getContext(), tvExchangeTitle, "Ninh Nguyen", getContext().getString(R.string.screen_exchange_exchange), "The Dip");
    }
}
