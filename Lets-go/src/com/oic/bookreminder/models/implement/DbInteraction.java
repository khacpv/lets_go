package com.oic.bookreminder.models.implement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.oic.bookreminder.config.ConfigDatabase;
import com.oic.bookreminder.models.api.IDbInteraction;
import com.oic.bookreminder.models.tables.*;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import java.util.List;

/**
 * Created by khacpham on 5/17/15.
 */
public class DbInteraction implements IDbInteraction {
    private static DbInteraction INSTANCE = null;
    private DaoSession daoSession;

    private DbInteraction(Context context) {
        String dbPath = context.getDatabasePath(ConfigDatabase.DATABASE_NAME).toString();
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, dbPath, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);

        daoSession = daoMaster.newSession(IdentityScopeType.None);
    }

    public static DbInteraction getInstance(Context context) {
        if (null == INSTANCE) {
            INSTANCE = new DbInteraction(context);
        }
        return INSTANCE;
    }

    @Override
    public User getUser() {
        try {
            UserDao userDao = daoSession.getUserDao();
            List<User> rs = userDao.queryBuilder()
                .where(UserDao.Properties.IsActivated.eq(true))
                .limit(1)
                .list();
            return null == rs || rs.size() == 0 ? null : rs.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User insert(User user) {
        try {
            UserDao userDao = daoSession.getUserDao();
            boolean success = userDao.insert(user) != 0;
            if (success) {
                return getUser();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(User user) {
        try {
            UserDao userDao = daoSession.getUserDao();
            userDao.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(long id) {
        if (id < 0) {
            id = getUser().getId();
        }
        try {
            UserDao userDao = daoSession.getUserDao();
            userDao.deleteByKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Notification getNotification(long id) {
        return null;
    }

    @Override
    public List<Notification> getNotifications() {
        return null;
    }

    @Override
    public boolean insertOrUpdateNotification(Notification notification) {
        return false;
    }

    @Override
    public boolean deleteNotification(long id) {
        return false;
    }

    @Override
    public boolean markNotificationAsRead(long id) {
        return false;
    }

    @Override
    public List<Book> getBooks() {
        BookDao bookDao = daoSession.getBookDao();
        return bookDao.queryBuilder()
            .orderDesc(BookDao.Properties.CreatedDate)
            .list();
    }

    @Override
    public Book getBookById(long id) {
        return daoSession.getBookDao()
            .queryBuilder()
            .where(BookDao.Properties.Id.eq(id))
            .unique();
    }

    @Override
    public boolean insertOrUpdateBook(Book book) {
        return daoSession.getBookDao().insertOrReplace(book) >= 0;
    }

    @Override
    public boolean insert(Book book) {
        try {
            List<Book> list = getBooks();
            if (list.isEmpty()) {
                return daoSession.getBookDao().insert(book) >= 0;
            }
            Book lastItem = list.get(list.size() - 1);
            book.setId(lastItem.getId() + 1);
            return daoSession.getBookDao().insert(book) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void deleteBook(long id) {
        daoSession.getBookDao().delete(getBookById(id));
    }
}
