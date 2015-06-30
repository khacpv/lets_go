package com.oic.bookreminder.app.mainscreen.suggest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.tables.Suggest;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomSuggestItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvAskTitle)
    TextView tvAskTitle;

    public CustomSuggestItem(Context context) {
        super(context);
        init();
    }

    public CustomSuggestItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomSuggestItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.suggest_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    public void setData(Suggest ask){
        TextFormat.setCommentTitleText(getContext(), tvAskTitle, "Ninh Nguyen", getContext().getString(R.string.screen_suggest_quote), "The Dip");
    }
}
