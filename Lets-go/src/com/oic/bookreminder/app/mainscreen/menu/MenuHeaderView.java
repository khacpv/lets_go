package com.oic.bookreminder.app.mainscreen.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/24/15.
 */
public class MenuHeaderView extends RelativeLayout {
    @InjectView(R.id.imvAvatar)
    public ImageView avatar;

    @InjectView(R.id.tvUsername)
    public TextView tvUsername;

    @InjectView(R.id.tvLevel)
    public TextView tvLevel;

    public MenuHeaderView(Context context) {
        super(context);
        initLayout();
    }

    public MenuHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public MenuHeaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout();
    }

    private void initLayout(){
        LayoutInflater.from(getContext()).inflate(R.layout.main_menu_header,this,true);
        ButterKnife.inject(this);
    }
}
