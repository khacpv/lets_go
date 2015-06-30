package com.oic.bookreminder.network.api;

import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.network.response.BookEnvelope;
import com.oic.bookreminder.network.response.CommentEnvelope;
import retrofit.http.*;
import rx.Observable;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IRestApi {

    // ============ BOOKS =========================
    @GET("/books")
    Observable<BookEnvelope> searchBook(@Query("searchKey")String searchKey,@Query("offset")int offset);

    @GET("/books")
    Observable<BookEnvelope> searchBook(@Query("searchKey")String searchKey,@Query("offset")int offset,@Query("limit")int limit);

    // ============ COMMENT =========================
    @GET("/comment")
    Observable<CommentEnvelope> getComment(@Query("offset")int offset, @Query("limit")int limit);

    @GET("/comment/book")
    Observable<CommentEnvelope> getComment(@Query("bookId")int bookId, @Query("offset")int offset, @Query("limit")int limit);

    @POST("/comment")
    Observable<CommentEnvelope.PostCommentEnvelope> postComment(@Body Comment comment);

    void deleteComment(int commentId);
}
