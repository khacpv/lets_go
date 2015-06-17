package com.oic.bookreminder.app.mainscreen.ask;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.tables.Ask;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomAskItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvAskTitle)
    TextView tvAskTitle;

    public CustomAskItem(Context context) {
        super(context);
        init();
    }

    public CustomAskItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomAskItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_ask_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    public void setData(Ask ask){
        TextFormat.setCommentTitleText(getContext(), tvAskTitle, "Ninh Nguyen", getContext().getString(R.string.screen_ask_asked), "The Dip");
    }
}
