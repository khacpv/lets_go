package com.oic.bookreminder.network.response;

import com.google.gson.annotations.SerializedName;
import com.oic.bookreminder.models.tables.Comment;

import java.util.List;

/**
 * Created by khacpham on 6/24/15.
 */
public class CommentEnvelope extends OicEnvelope {

    @SerializedName("query")
    public String query;

    @SerializedName("data")
    public List<Comment> data;

    public static class PostCommentEnvelope extends OicEnvelope{
        @SerializedName("data")
        public int data;
    }
}
