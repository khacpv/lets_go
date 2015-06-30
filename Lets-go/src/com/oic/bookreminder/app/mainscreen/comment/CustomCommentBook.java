package com.oic.bookreminder.app.mainscreen.comment;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.oic.bookreminder.GlobalStorage;
import com.oic.bookreminder.R;
import com.oic.bookreminder.models.implement.TableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.UserBook;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomCommentBook extends RelativeLayout{
    RelativeLayout layout;

    @InjectView(R.id.imvCommentBookAvatar)
    ImageView imvCommentBookAvatar;

    @InjectView(R.id.tvCommentBookTitle)
    TextView tvCommentBookTitle;

    @InjectView(R.id.tvCommentBookAuthor)
    TextView tvCommentBookAuthor;

    @InjectView(R.id.tvCommentBookDescription)
    TextView tvCommentBookDescription;

    @InjectView(R.id.tvCommentBookSaveToShelf)
    TextView tvCommentBookSaveToShelf;

    private OnBookClickListener listener;

    Book data;
    UserBook userBook;

    public CustomCommentBook(Context context) {
        super(context);
        init();
    }

    public CustomCommentBook(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCommentBook(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        try {
            layout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.comment_book, null);
            addView(layout);
            ButterKnife.inject(this);

            initDefaultData();
        }catch (Exception e){

        }
    }

    private void initDefaultData(){

    }

    @OnClick(R.id.tvCommentBookTitle)
    public void tvCommentBookTitle(){
        if(null == listener) return;
        listener.titleBookClick(this,data);
    }

    @OnClick(R.id.tvCommentBookAuthor)
    public void tvCommentBookAuthor(){
        if(null == listener) return;
        listener.authorBookClick(this, data);
    }

    @OnClick(R.id.tvCommentBookDescription)
    public void tvCommentBookDescription(){
        if(null == listener) return;
        listener.descBookClick(this, data);
    }

    @OnClick(R.id.tvCommentBookSaveToShelf)
    public void tvCommentBookSaveToShelfClick(){
        if(null == listener) return;
        listener.saveBookClick(this, data, userBook);
    }

    public void setSaved(boolean isSaved){
        tvCommentBookSaveToShelf.setSelected(isSaved);
    }

    public void setData(Book book){
        this.data = book;
        imvCommentBookAvatar.setImageDrawable(null);
        ImageLoader.getInstance().displayImage(book.getThumbnail(), imvCommentBookAvatar,new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                view.setAnimation(anim);
                anim.start();
            }
        });
        this.userBook = TableInteraction.getInstance(getContext()).checkSavedBook(GlobalStorage.USER.getUserId(),book.getBookId());
        tvCommentBookTitle.setText(book.getTitle()+"");
        tvCommentBookAuthor.setText(book.getAuthor());
        tvCommentBookDescription.setText(book.getDescription());

        tvCommentBookSaveToShelf.setSelected(userBook != null);
    }

    public void setOnBookClickListener(OnBookClickListener listener){
        this.listener = listener;
    }

    public static class BookClickListenerDefault implements OnBookClickListener{

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

    public interface OnBookClickListener{
        void titleBookClick(CustomCommentBook view,Book data);
        void authorBookClick(CustomCommentBook view,Book data);
        void descBookClick(CustomCommentBook view,Book data);
        void saveBookClick(CustomCommentBook view, Book data,UserBook userBook);
    }
}
