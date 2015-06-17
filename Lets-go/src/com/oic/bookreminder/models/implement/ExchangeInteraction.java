package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Exchange;
import com.oic.bookreminder.models.tables.ExchangeDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class ExchangeInteraction extends DbInteraction{
    public static ExchangeInteraction _INSTANCE = null;

    public ExchangeInteraction(Context context) {
        super(context);
    }

    public static ExchangeInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new ExchangeInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<Exchange> getExchanges() {
        ExchangeDao dataDao = getDaoSession().getExchangeDao();
        return dataDao.queryBuilder()
            .orderDesc(ExchangeDao.Properties.CreatedDate)
            .list();
    }

    public Exchange getExchangeById(long id) {
        return getDaoSession().getExchangeDao()
            .queryBuilder()
            .where(ExchangeDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateExchange(Exchange Exchange) {
        return getDaoSession().getExchangeDao().insertOrReplace(Exchange) >= 0;
    }

    public boolean insert(Exchange Exchange) {
        try {
            List<Exchange> list = getExchanges();
            if (list.isEmpty()) {
                return getDaoSession().getExchangeDao().insert(Exchange) >= 0;
            }
            Exchange lastItem = list.get(list.size() - 1);
            Exchange.setId(lastItem.getId() + 1);
            return getDaoSession().getExchangeDao().insert(Exchange) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteExchange(long id) {
        getDaoSession().getExchangeDao().delete(getExchangeById(id));
    }
}
