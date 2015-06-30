package com.oic.bookreminder.app.mainscreen.comment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.InjectView;
import com.oic.bookreminder.GlobalStorage;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.mainscreen.FragmentMain;
import com.oic.bookreminder.common.utils.LogUtils;
import com.oic.bookreminder.common.views.CustomActionbar;
import com.oic.bookreminder.common.views.CustomHeader;
import com.oic.bookreminder.models.implement.TableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.UserBook;
import com.oic.bookreminder.network.implement.RestApi;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentComment extends AppFragment implements CustomActionbar.OnSearchable {

    @InjectView(R.id.listComment)
    ListView listComment;

    @InjectView(R.id.commentSearchLayout)
    ListView commentSearchLayout;

    AdapterComment adapterComment;
    List<Comment> comments;

    private CustomCommentItem.OnCustomCommentItemClick listener = new CustomCommentItem.CustomCommentItemClickDefault(){
        @Override
        public void titleClick(CustomCommentItem view, Comment data) {
            Toast.makeText(getActivity(),data.getBookTitle(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void commentClick(CustomCommentItem view, Comment data) {
            GlobalStorage.BOOK = TableInteraction.getInstance(getActivity()).getBookByServerId(data.getBookId());

            LogUtils.logE("comment click");

            long bookId = data.getBookId();
            FragmentMain.FRG_MAIN.setCurrentFragment(CustomHeader.TAB.COMMENT_DETAIL);
        }

        @Override
        public void titleBookClick(CustomCommentBook view, Book data) {

        }

        @Override
        public void saveBookClick(CustomCommentBook view, Book data, UserBook userBook) {
            if(null == userBook){
                LogUtils.logE("insert");
                userBook = new UserBook();
                userBook.setBookId(data.getBookId());
                userBook.setUserId(GlobalStorage.USER.getUserId());
                userBook.setQuantity(0);
                TableInteraction.getInstance(getActivity()).insertOrUpdateUserBook(userBook);
            }
            else {
                LogUtils.logE("delete");
                TableInteraction.getInstance(getActivity()).deleteUserBook(userBook);
            }
            adapterComment.notifyDataSetChanged();
        }
    };

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_fragment,null);
        return view;
    }

    @Override
    protected void findControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        comments = new ArrayList<>();
        adapterComment = new AdapterComment(getActivity(),comments,listener);
        listComment.setAdapter(adapterComment);

        comments = TableInteraction.getInstance(getActivity()).getComments();
        setComments(comments);

        // try to get books
        RestApi.getInstance(this.getActivity()).getBooksFromServer("", 0, 10)
            .subscribe(new Subscriber<List<Book>>() {

                @Override
                public void onNext(List<Book> books) {

                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    LogUtils.logE("get books complete");
                }
            });

        RestApi.getInstance(this.getActivity()).getCommentsFromServer(0, 10)
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
                    setComments(comments);
                }
            });
    }

    @Override
    public void onSearch(String text) {
        setSearching(0 < text.length());
        if(0 < text.length()){

        }
    }

    private void setSearching(boolean isSearching){
        if(isSearching){
            commentSearchLayout.setVisibility(View.VISIBLE);
            listComment.setVisibility(View.GONE);
        }else{
            commentSearchLayout.setVisibility(View.GONE);
            listComment.setVisibility(View.VISIBLE);
        }
    }

    public void setComments(List<Comment> comments){
        adapterComment.setComments(comments);
    }
}
