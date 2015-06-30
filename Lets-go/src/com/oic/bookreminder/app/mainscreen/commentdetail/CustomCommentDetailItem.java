package com.oic.bookreminder.app.mainscreen.commentdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.mainscreen.comment.CustomCommentItem;
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.implement.TableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.User;

import java.util.List;

/**
 * Created by khacpham on 6/18/15.
 */
public class CustomCommentDetailItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvCommentTitle)
    TextView tvCommentTitle;

    @InjectView(R.id.viewCommentBook)
    TextView commentBook;

    @InjectView(R.id.tvCommentTime)
    TextView tvCommentTime;

    @InjectView(R.id.tvCommentLike)
    TextView tvCommentLike;

    @InjectView(R.id.imvCommentAvatar)
    ImageView imvCommentAvatar;

    private Comment data;

    private CustomCommentItem.OnCustomCommentItemClick listener;

    public CustomCommentDetailItem(Context context) {
        super(context);
        init();
    }

    public CustomCommentDetailItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCommentDetailItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.comment_detail_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    @OnClick(R.id.tvCommentTitle)
    public void tvCommentTitleClick(){
        if(null == listener)return;
        listener.titleClick(null,data);
    }

    @OnClick(R.id.tvCommentTime)
    public void tvCommentTimeClick(){
        if(null == listener)return;
        listener.timeClick(null, data);
    }

    @OnClick(R.id.tvCommentLike)
    public void tvCommentLikeClick(){
        if(null == listener)return;
        listener.likeClick(null, data);
    }

    @OnClick(R.id.imvCommentAvatar)
    public void imvCommentAvatarClick(){
        if(null == listener)return;
        listener.avatarClick(null, data);
    }

    public Comment getData(){
        return data;
    }

    public void setData(Comment data){
        this.data = data;
        User user = TableInteraction.getInstance(getContext()).getUserByServerId(data.getUserId());
        List<Book> books = TableInteraction.getInstance(getContext()).getBooks();
        Book book = TableInteraction.getInstance(getContext()).getBookByServerId(data.getBookId());
        TextFormat.setCommentTitleText(getContext(), tvCommentTitle, data.getUserName(), getContext().getString(R.string.screen_comment_commented), data.getBookTitle());
        tvCommentLike.setText(String.format(getContext().getResources().getString(R.string.screen_comment_like), book.getLikeNumber().toString()));
        ImageLoader.getInstance().displayImage(user.getAvatarUrl(), imvCommentAvatar);
        commentBook.setText(data.getContent());
    }

    public void setOnCustomCommentItemClickListener(CustomCommentItem.OnCustomCommentItemClick listener){
        this.listener = listener;
    }

}
