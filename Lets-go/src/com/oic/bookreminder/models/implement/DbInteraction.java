package com.oic.bookreminder.models.implement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.oic.bookreminder.config.ConfigDatabase;
import com.oic.bookreminder.models.api.IDbInteraction;
import com.oic.bookreminder.models.tables.DaoMaster;
import com.oic.bookreminder.models.tables.DaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/**
 * Created by khacpham on 5/17/15.
 */
public class DbInteraction implements IDbInteraction {
    private static DbInteraction INSTANCE = null;
    private static DaoSession daoSession;
    protected Context context;

    public DbInteraction(Context context) {
        this.context = context;
        if(null == daoSession) {
            String dbPath = context.getDatabasePath(ConfigDatabase.DATABASE_NAME).toString();
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, dbPath, null);
            SQLiteDatabase db = helper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);

            daoSession = daoMaster.newSession(IdentityScopeType.None);
        }
    }

    public DaoSession getDaoSession(){
        if(null == daoSession) {
            String dbPath = context.getDatabasePath(ConfigDatabase.DATABASE_NAME).toString();
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, dbPath, null);
            SQLiteDatabase db = helper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);

            daoSession = daoMaster.newSession(IdentityScopeType.None);
        }
        return daoSession;
    }
}
