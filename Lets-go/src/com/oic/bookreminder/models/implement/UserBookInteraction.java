package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.UserBook;
import com.oic.bookreminder.models.tables.UserBookDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class UserBookInteraction extends DbInteraction{
    public static UserBookInteraction _INSTANCE = null;

    public UserBookInteraction(Context context) {
        super(context);
    }

    public static UserBookInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new UserBookInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<UserBook> getUserBooks() {
        UserBookDao dataDao = getDaoSession().getUserBookDao();
        return dataDao.queryBuilder()
            .orderDesc(UserBookDao.Properties.Id)
            .list();
    }

    public UserBook getUserBookById(long id) {
        return getDaoSession().getUserBookDao()
            .queryBuilder()
            .where(UserBookDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateUserBook(UserBook UserBook) {
        return getDaoSession().getUserBookDao().insertOrReplace(UserBook) >= 0;
    }

    public boolean insert(UserBook UserBook) {
        try {
            List<UserBook> list = getUserBooks();
            if (list.isEmpty()) {
                return getDaoSession().getUserBookDao().insert(UserBook) >= 0;
            }
            UserBook lastItem = list.get(list.size() - 1);
            UserBook.setId(lastItem.getId() + 1);
            return getDaoSession().getUserBookDao().insert(UserBook) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteUserBook(long id) {
        getDaoSession().getUserBookDao().delete(getUserBookById(id));
    }
}
