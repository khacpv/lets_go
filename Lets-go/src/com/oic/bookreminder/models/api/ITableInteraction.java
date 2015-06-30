package com.oic.bookreminder.models.api;

import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.User;

import java.util.List;

/**
 * Created by khacpham on 6/20/15.
 */
public interface ITableInteraction extends IDbInteraction{
    /*=============== USER =======================================*/
    User getLoggedInUser();
    User getUserByServerId(long id);
    User insertUser(User user);
    boolean updateUser(User user);

    /*=============== BOOK =======================================*/
    Book getBookByServerId(long serverId);


    /*=============== COMMENT =======================================*/
    List<Comment> getComments();
}
