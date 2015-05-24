package com.oic.bookreminder.models.api;

import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Notification;
import com.oic.bookreminder.models.tables.User;

import java.util.List;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IDbInteraction {
    /*=============== USER =======================================*/

    User getUser();
    User insert(User user);
    boolean update(User user);
    boolean deleteUser(long id);

    /*=============== NOTIFICATION ===============================*/

    Notification getNotification(long id);
    List<Notification> getNotifications();
    boolean insertOrUpdateNotification(Notification notification);
    boolean deleteNotification(long id);
    boolean markNotificationAsRead(long id);

    /*=============== BOOK ===============================*/

    List<Book> getBooks();
    Book getBookById(long id);
    boolean insertOrUpdateBook(Book book);
    boolean insert(Book book);
    void deleteBook(long id);
}
