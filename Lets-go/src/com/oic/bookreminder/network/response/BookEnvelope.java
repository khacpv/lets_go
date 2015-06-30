package com.oic.bookreminder.network.response;

import com.google.gson.annotations.SerializedName;
import com.oic.bookreminder.models.tables.Book;

import java.util.List;

/**
 * Created by khacpham on 6/23/15.
 */
public class BookEnvelope extends OicEnvelope{

    @SerializedName("query")
    public String query;

    @SerializedName("data")
    public List<Book> data;
}
