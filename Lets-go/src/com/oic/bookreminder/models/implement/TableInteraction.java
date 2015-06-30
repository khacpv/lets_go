package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.api.ITableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.User;
import com.oic.bookreminder.models.tables.UserBook;

import java.util.List;

/**
 * Created by khacpham on 6/20/15.
 */
public class TableInteraction extends DbInteraction implements ITableInteraction{
    private static TableInteraction INSTANCE = null;

    private SuggestInteraction suggestInteraction;
    private BookInteraction bookInteraction;
    private CommentInteraction commentInteraction;
    private ExchangeInteraction exchangeInteraction;
    private NotificationInteraction notificationInteraction;
    private UserInteraction userInteraction;
    private UserBookInteraction userBookInteraction;

    public TableInteraction(Context context) {
        super(context);

        suggestInteraction = (SuggestInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.ASK);
        bookInteraction = (BookInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.BOOK);
        commentInteraction = (CommentInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.COMMENT);
        exchangeInteraction = (ExchangeInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.EXCHANGE);
        notificationInteraction = (NotificationInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.NOTIFICATION);
        userInteraction = (UserInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.USER);
        userBookInteraction = (UserBookInteraction)DbFactory.getDbInteraction(context, DbFactory.DB_TYPE.USERBOOK);
    }

    public static TableInteraction getInstance(Context context){
        if(null == INSTANCE){
            INSTANCE = new TableInteraction(context);
        }
        return INSTANCE;
    }


    @Override
    public User getLoggedInUser() {
        return userInteraction.getUser();
    }

    @Override
    public User getUserByServerId(long id){
        return userInteraction.getUserByServerId(id);
    }

    @Override
    public User insertUser(User user) {
        return userInteraction.insert(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userInteraction.update(user);
    }

    @Override
    public Book getBookByServerId(long serverId) {
        return bookInteraction.getBookByServerId(serverId);
    }

    public boolean insertOrUpdateBook(Book book){
        return bookInteraction.insertOrUpdateBook(book);
    }

    public boolean insertBook(Book book){
        return bookInteraction.insert(book);
    }

    public List<Comment> getComments(){
        return commentInteraction.getComments();
    }

    public List<Comment> getCommentByBookId(long bookId){
        return commentInteraction.getCommentByBookId(bookId);
    }

    public boolean insertComment(Comment data){
        return commentInteraction.insert(data);
    }

    public List<UserBook> getUserBook(){
        return userBookInteraction.getUserBooks();
    }

    public UserBook checkSavedBook(long userId, long bookId){
        return userBookInteraction.checkSavedBook(userId, bookId);
    }

    public boolean insertUserBook(UserBook userBook) {
        return userBookInteraction.insert(userBook);
    }

    public boolean updateUserBook(UserBook userBook) {
        return userBookInteraction.insertOrUpdateUserBook(userBook);
    }

    public boolean insertOrUpdateUserBook(UserBook userBook){
        return userBookInteraction.insertOrUpdateUserBook(userBook);
    }

    public void deleteUserBook(UserBook userBook){
        userBookInteraction.deleteUserBook(userBook.getId());
    }

    public List<Book> getBooks() {
        return bookInteraction.getBooks();
    }
}
