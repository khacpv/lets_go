package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Ask;
import com.oic.bookreminder.models.tables.AskDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class AskInteraction extends DbInteraction {
    public static AskInteraction _INSTANCE = null;

    public AskInteraction(Context context) {
        super(context);
    }

    public static AskInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new AskInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<Ask> getAsks() {
        AskDao askDao = getDaoSession().getAskDao();
        return askDao.queryBuilder()
            .orderDesc(AskDao.Properties.CreatedDate)
            .list();
    }

    public Ask getAskById(long id) {
        return getDaoSession().getAskDao()
            .queryBuilder()
            .where(AskDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateAsk(Ask Ask) {
        return getDaoSession().getAskDao().insertOrReplace(Ask) >= 0;
    }

    public boolean insert(Ask Ask) {
        try {
            List<Ask> list = getAsks();
            if (list.isEmpty()) {
                return getDaoSession().getAskDao().insert(Ask) >= 0;
            }
            Ask lastItem = list.get(list.size() - 1);
            Ask.setId(lastItem.getId() + 1);
            return getDaoSession().getAskDao().insert(Ask) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteAsk(long id) {
        getDaoSession().getAskDao().delete(getAskById(id));
    }
}
