package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.User;
import com.oic.bookreminder.models.tables.UserDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class UserInteraction extends  DbInteraction{
    public static UserInteraction _INSTANCE = null;

    private UserInteraction(Context context) {
        super(context);
    }

    public static UserInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new UserInteraction(ctx);
        }
        return _INSTANCE;
    }

    public User getUser() {
        try {
            UserDao userDao = getDaoSession().getUserDao();
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

    public User insert(User user) {
        try {
            UserDao userDao = getDaoSession().getUserDao();
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

    public boolean update(User user) {
        try {
            UserDao userDao = getDaoSession().getUserDao();
            userDao.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(long id) {
        if (id < 0) {
            id = getUser().getId();
        }
        try {
            UserDao userDao = getDaoSession().getUserDao();
            userDao.deleteByKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
