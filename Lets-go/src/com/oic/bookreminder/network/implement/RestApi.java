package com.oic.bookreminder.network.implement;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oic.bookreminder.config.ConfigNetwork;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.network.api.IRestApi;
import com.oic.bookreminder.network.response.BookEnvelope;
import com.oic.bookreminder.network.response.CommentEnvelope;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * Created by khacpham on 5/17/15.
 */
public class RestApi {
    private static RestApi _INSTANCE = null;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    Context context;
    RestAdapter restAdapter;
    IRestApi restService;
    Gson gson;

    private RestApi(Context context) {
        this.context = context;

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        this.gson = new GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .create();

        this.restAdapter = new RestAdapter.Builder()
            .setEndpoint(ConfigNetwork.ENDPOINT)
            .setRequestInterceptor(requestInterceptor)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setConverter(new GsonConverter(gson))
            .build();
        this.restService = restAdapter.create(IRestApi.class);
    }

    public static RestApi getInstance(Context context) {
        if (null == _INSTANCE) {
            _INSTANCE = new RestApi(context);
        }
        return _INSTANCE;
    }

    public static IRestApi getApi(Context context) {
        return getInstance(context).restService;
    }


    public rx.Observable<List<Book>> getBooksFromServer(String searchKey, int offset, int limit) {
        return _INSTANCE.restService.searchBook(searchKey, offset, limit)
            .flatMap(new Func1<BookEnvelope, rx.Observable<? extends BookEnvelope>>() {
                @Override
                public rx.Observable<? extends BookEnvelope> call(BookEnvelope data) {
                    return data.filterWebServiceErrors();
                }
            })
            .map(new Func1<BookEnvelope, List<Book>>() {
                @Override
                public List<Book> call(BookEnvelope bookEnvelope) {
                    return bookEnvelope.data;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public rx.Observable<List<Comment>> getCommentsFromServer(int offset, int limit){
        return _INSTANCE.restService.getComment(offset, limit)
            .flatMap(new Func1<CommentEnvelope, rx.Observable<? extends CommentEnvelope>>() {
                @Override
                public rx.Observable<? extends CommentEnvelope> call(CommentEnvelope data) {
                    return data.filterWebServiceErrors();
                }
            })
            .map(new Func1<CommentEnvelope, List<Comment>>() {
                @Override
                public List<Comment> call(CommentEnvelope envelope) {
                    return envelope.data;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public rx.Observable<List<Comment>> getBookCommentsFromServer(int bookId, int offset, int limit){
        return _INSTANCE.restService.getComment(bookId, offset, limit)
            .flatMap(new Func1<CommentEnvelope, rx.Observable<? extends CommentEnvelope>>() {
                @Override
                public rx.Observable<? extends CommentEnvelope> call(CommentEnvelope data) {
                    return data.filterWebServiceErrors();
                }
            })
            .map(new Func1<CommentEnvelope, List<Comment>>() {
                @Override
                public List<Comment> call(CommentEnvelope envelope) {
                    return envelope.data;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Integer> createCommentToServer(Comment comment){
        return _INSTANCE.restService.postComment(comment)
            .flatMap(new Func1<CommentEnvelope.PostCommentEnvelope, rx.Observable < ?extends CommentEnvelope.PostCommentEnvelope>>() {
                @Override
                public rx.Observable<? extends CommentEnvelope.PostCommentEnvelope> call(CommentEnvelope.PostCommentEnvelope data) {
                    return data.filterWebServiceErrors();
                }
            })
            .map(new Func1<CommentEnvelope.PostCommentEnvelope, Integer>() {
                @Override
                public Integer call(CommentEnvelope.PostCommentEnvelope envelope) {
                    return envelope.data;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
