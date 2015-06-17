package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.BookDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class BookInteraction extends DbInteraction{
    public static BookInteraction _INSTANCE = null;

    public BookInteraction(Context context) {
        super(context);
    }

    public static BookInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new BookInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<Book> getBooks() {
        BookDao dataDao = getDaoSession().getBookDao();
        return dataDao.queryBuilder()
            .orderDesc(BookDao.Properties.CreatedDate)
            .list();
    }

    public Book getBookById(long id) {
        return getDaoSession().getBookDao()
            .queryBuilder()
            .where(BookDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateBook(Book book) {
        return getDaoSession().getBookDao().insertOrReplace(book) >= 0;
    }

    public boolean insert(Book book) {
        try {
            List<Book> list = getBooks();
            if (list.isEmpty()) {
                return getDaoSession().getBookDao().insert(book) >= 0;
            }
            Book lastItem = list.get(list.size() - 1);
            book.setId(lastItem.getId() + 1);
            return getDaoSession().getBookDao().insert(book) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteBook(long id) {
        getDaoSession().getBookDao().delete(getBookById(id));
    }
}
