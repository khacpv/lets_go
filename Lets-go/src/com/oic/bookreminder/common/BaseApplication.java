package com.oic.bookreminder.common;

import android.app.Application;
import com.oic.bookreminder.config.ConfigApp;
import com.oic.bookreminder.models.implement.DbInteraction;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class BaseApplication extends Application{
    protected DbInteraction mDbInteraction;

    @Override
    public void onCreate() {
        super.onCreate();

        mDbInteraction = DbInteraction.getInstance(this);
        ConfigApp.USER = mDbInteraction.getUser();
    }
}
