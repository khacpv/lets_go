package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Suggest;
import com.oic.bookreminder.models.tables.SuggestDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class SuggestInteraction extends DbInteraction {
    public static SuggestInteraction _INSTANCE = null;

    public SuggestInteraction(Context context) {
        super(context);
    }

    public static SuggestInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new SuggestInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<Suggest> getSuggests() {
        SuggestDao suggestDao = getDaoSession().getSuggestDao();
        return suggestDao.queryBuilder()
            .list();
    }

    public Suggest getSuggestById(long id) {
        return getDaoSession().getSuggestDao()
            .queryBuilder()
            .where(SuggestDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateSuggest(Suggest Suggest) {
        return getDaoSession().getSuggestDao().insertOrReplace(Suggest) >= 0;
    }

    public boolean insert(Suggest Suggest) {
        try {
            List<Suggest> list = getSuggests();
            if (list.isEmpty()) {
                return getDaoSession().getSuggestDao().insert(Suggest) >= 0;
            }
            Suggest lastItem = list.get(list.size() - 1);
            Suggest.setId(lastItem.getId() + 1);
            return getDaoSession().getSuggestDao().insert(Suggest) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteSuggest(long id) {
        getDaoSession().getSuggestDao().delete(getSuggestById(id));
    }
}
