package com.oic.bookreminder.models.api;

import com.oic.bookreminder.models.tables.DaoSession;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IDbInteraction {
    /*=============== DEFAULT =======================================*/
    DaoSession getDaoSession();
}
