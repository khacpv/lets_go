package com.oic.bookreminder.app.mainscreen.comment;

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
import com.oic.bookreminder.common.utils.TextFormat;
import com.oic.bookreminder.models.implement.TableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.User;
import com.oic.bookreminder.models.tables.UserBook;

import java.util.List;

/**
 * Created by khacpham on 6/18/15.
 */
public class CustomCommentItem extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.tvCommentTitle)
    TextView tvCommentTitle;

    @InjectView(R.id.viewCommentBook)
    CustomCommentBook commentBook;

    @InjectView(R.id.tvCommentTime)
    TextView tvCommentTime;

    @InjectView(R.id.tvCommentNumber)
    TextView tvCommentNumber;

    @InjectView(R.id.tvCommentLike)
    TextView tvCommentLike;

    @InjectView(R.id.imvCommentAvatar)
    ImageView imvCommentAvatar;

    private Comment data;

    private OnCustomCommentItemClick listener;

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
        layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.comment_item,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){

    }

    @OnClick(R.id.tvCommentTitle)
    public void tvCommentTitleClick(){
        if(null == listener)return;
        listener.titleClick(this,data);
    }

    @OnClick(R.id.tvCommentTime)
    public void tvCommentTimeClick(){
        if(null == listener)return;
        listener.timeClick(this, data);
    }

    @OnClick(R.id.tvCommentNumber)
    public void tvCommentNumberClick(){
        if(null == listener)return;
        listener.commentClick(this, data);
    }

    @OnClick(R.id.tvCommentLike)
    public void tvCommentLikeClick(){
        if(null == listener)return;
        listener.likeClick(this, data);
    }

    @OnClick(R.id.imvCommentAvatar)
    public void imvCommentAvatarClick(){
        if(null == listener)return;
        listener.avatarClick(this, data);
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
        tvCommentNumber.setText(String.format(getContext().getResources().getString(R.string.screen_comment_number),book.getCommentNumber().toString()));
        ImageLoader.getInstance().displayImage(user.getAvatarUrl(), imvCommentAvatar);
        commentBook.setData(book);
        commentBook.setOnBookClickListener(listener);
    }

    public void setOnCustomCommentItemClickListener(OnCustomCommentItemClick listener){
        this.listener = listener;
    }

    public static class CustomCommentItemClickDefault implements OnCustomCommentItemClick{

        @Override
        public void avatarClick(CustomCommentItem view, Comment data) {

        }

        @Override
        public void titleClick(CustomCommentItem view, Comment data) {

        }

        @Override
        public void timeClick(CustomCommentItem view, Comment data) {

        }

        @Override
        public void commentClick(CustomCommentItem view, Comment data) {

        }

        @Override
        public void likeClick(CustomCommentItem view, Comment data) {

        }

        @Override
        public void titleBookClick(CustomCommentBook view, Book data) {

        }

        @Override
        public void authorBookClick(CustomCommentBook view, Book data) {

        }

        @Override
        public void descBookClick(CustomCommentBook view, Book data) {

        }

        @Override
        public void saveBookClick(CustomCommentBook view, Book data, UserBook userBook) {

        }
    }

    public interface OnCustomCommentItemClick extends CustomCommentBook.OnBookClickListener{
        void avatarClick(CustomCommentItem view,Comment data);
        void titleClick(CustomCommentItem view,Comment data);
        void timeClick(CustomCommentItem view,Comment data);
        void commentClick(CustomCommentItem view,Comment data);
        void likeClick(CustomCommentItem view,Comment data);
    }
}
