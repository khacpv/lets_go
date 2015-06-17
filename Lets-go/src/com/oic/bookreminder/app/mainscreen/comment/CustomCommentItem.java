package com.oic.bookreminder.app.mainscreen.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.tables.Comment;

/**
 * Created by khacpham on 6/18/15.
 */
public class CustomCommentItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvCommentTitle)
    TextView tvCommentTitle;

    @InjectView(R.id.viewCommentBook)
    CustomCommentBook commentBook;

    public CustomCommentItem(Context context) {
        super(context);
        init();
    }

    public CustomCommentItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCommentItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_comment_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    public void setData(Comment data){
        TextFormat.setCommentTitleText(getContext(), tvCommentTitle, "Ninh Nguyen", getContext().getString(R.string.screen_comment_commented), "The Dip");
    }
}
