package com.oic.bookreminder.app.mainscreen.commentdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.oic.bookreminder.GlobalStorage;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.mainscreen.comment.CustomCommentItem;
import com.oic.bookreminder.common.utils.LogUtils;
import com.oic.bookreminder.common.views.CustomActionbar;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.network.implement.RestApi;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/20/15.
 */
public class FragmentCommentDetail extends AppFragment implements CustomActionbar.OnSearchable {

    Book book;

    View layout;

    @InjectView(R.id.imvCommentAvatar)
    ImageView imvCommentAvatar;

    @InjectView(R.id.tvName)
    TextView tvName;

    @InjectView(R.id.btnPostComment)
    ImageButton btnPostComment;

    @InjectView(R.id.edtCommentText)
    EditText edtCommentText;

    @InjectView(R.id.listComment)
    ListView listCommentSearch;

    List<Comment> comments = new ArrayList<>();
    AdapterCommentDetail adapterCommentDetail;

    CustomCommentItem.OnCustomCommentItemClick commentClickListner = new CustomCommentItem.CustomCommentItemClickDefault(){

    };

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.comment_detail_fragment,null);
        ButterKnife.inject(this, layout);
        return layout;
    }

    @Override
    protected void initializeDefaultData() {
        book = GlobalStorage.BOOK;

        tvName.setText(GlobalStorage.USER.getDisplayName());
        ImageLoader.getInstance().displayImage(GlobalStorage.USER.getAvatarUrl(), imvCommentAvatar);

        adapterCommentDetail = new AdapterCommentDetail(this.getActivity(),comments,commentClickListner);
        listCommentSearch.setAdapter(adapterCommentDetail);

        updateDataFromServer();
    }

    public void updateDataFromServer(){
        // try to get comment detail
        RestApi.getInstance(FragmentCommentDetail.this.getActivity()).getBookCommentsFromServer(Integer.valueOf(book.getBookId().toString()), 0, 10)
            .subscribe(new Subscriber<List<Comment>>() {
                @Override
                public void onCompleted() {
                    LogUtils.logE("get comments complete");
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onNext(List<Comment> comments) {
                    setData(book, comments);
                }
            });
    }

    public void setData(Book book, List<Comment> comments){
        this.comments = comments;
        adapterCommentDetail.setComments(this.comments);
    }

    @OnClick(R.id.btnPostComment)
    public void postComment(View v){
        String text = edtCommentText.getText().toString();
        if(text.trim().length() < 5){
            Toast.makeText(this.getActivity(),"Content must larger 5 characters",Toast.LENGTH_SHORT).show();
            return;
        }
        long bookId = GlobalStorage.BOOK.getBookId();
        String bookTitle = GlobalStorage.BOOK.getTitle();
        long userId = GlobalStorage.USER.getUserId();
        String userName = GlobalStorage.USER.getDisplayName();

        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setUserName(userName);
        comment.setBookId(bookId);
        comment.setBookTitle(bookTitle);
        comment.setContent(text);

        // try to get comment detail
        RestApi.getInstance(this.getActivity()).createCommentToServer(comment)
            .subscribe(new Subscriber<Integer>() {
                @Override
                public void onCompleted() {
                    LogUtils.logE("get comments complete");
                    edtCommentText.setText("");
                    Toast.makeText(FragmentCommentDetail.this.getActivity(),"Post complete",Toast.LENGTH_SHORT).show();
                    updateDataFromServer();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                    updateDataFromServer();
                }

                @Override
                public void onNext(Integer commentId) {
                }
            });
    }

    @Override
    public void onSearch(String text) {
        if(null == text || text.trim().length() ==0){
            return;
        }
        Toast.makeText(this.getActivity(),text,Toast.LENGTH_SHORT).show();
    }
}
