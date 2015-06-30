package com.oic.bookreminder.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomHeader extends LinearLayout{
    TAB currentTab = TAB.COMMENT;

    LinearLayout layout;

    @InjectView(R.id.tvComment)
    TextView tvComment;

    @InjectView(R.id.tvAsk)
    TextView tvAsk;

    @InjectView(R.id.tvExchange)
    TextView tvExchange;

    OnHeaderListener listener;

    public CustomHeader(Context context) {
        super(context);
        init();
    }

    public CustomHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.main_tab,null);
        addView(layout);
        ButterKnife.inject(this, layout);
        setCurrentTab(currentTab);
    }

    @OnClick({R.id.tvComment,R.id.tvAsk,R.id.tvExchange})
    public void onTabClick(View v){
        switch (v.getId()){
            case R.id.tvComment:
                setCurrentTab(TAB.COMMENT);
                break;
            case R.id.tvAsk:
                setCurrentTab(TAB.ASK);
                break;
            case R.id.tvExchange:
                setCurrentTab(TAB.EXCHANGE);
                break;

        }
    }

    public TAB getCurrentTab(){
        return currentTab;
    }

    public void setCurrentTabFix(TAB tab){
        this.currentTab = tab;
    }

    public void setCurrentTab(TAB tab){
        this.currentTab = tab;

        tvComment.setSelected(false);
        tvAsk.setSelected(false);
        tvExchange.setSelected(false);

        tvComment.setTextColor(getResources().getColor(R.color.green_text));
        tvAsk.setTextColor(getResources().getColor(R.color.green_text));
        tvExchange.setTextColor(getResources().getColor(R.color.green_text));

        View view = tvComment;
        switch (tab){
            case COMMENT:
            case COMMENT_DETAIL:
                tvComment.setSelected(true);
                tvComment.setTextColor(getResources().getColor(R.color.white));
                view = tvComment;
                break;
            case ASK:
                tvAsk.setSelected(true);
                tvAsk.setTextColor(getResources().getColor(R.color.white));
                view = tvAsk;
                break;
            case EXCHANGE:
                tvExchange.setSelected(true);
                tvExchange.setTextColor(getResources().getColor(R.color.white));
                view = tvExchange;
                break;
        }
        if(null != listener){
            listener.onTabChange(view, view.getId(),tab);
        }
    }

    public enum TAB{
        COMMENT,COMMENT_DETAIL, ASK, EXCHANGE
    }

    public void setOnHeaderListener(OnHeaderListener listener){
        this.listener = listener;
    }

    public interface OnHeaderListener{
        void onTabChange(View v,int id,TAB tab);
    }
}
