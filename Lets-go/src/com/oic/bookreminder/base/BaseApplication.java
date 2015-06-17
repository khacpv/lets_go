package com.oic.bookreminder.base;

import android.app.Application;
import com.oic.bookreminder.config.ConfigApp;
import com.oic.bookreminder.models.implement.DbFactory;
import com.oic.bookreminder.models.implement.UserInteraction;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class BaseApplication extends Application{
    protected UserInteraction mUserDb;

    @Override
    public void onCreate() {
        super.onCreate();

        mUserDb = (UserInteraction)DbFactory.getDbInteraction(this, DbFactory.DB_TYPE.USER);
        ConfigApp.USER = mUserDb.getUser();
    }
}
