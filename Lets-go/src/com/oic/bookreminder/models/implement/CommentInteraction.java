package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.CommentDao;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class CommentInteraction extends DbInteraction {
    public static CommentInteraction _INSTANCE = null;

    public CommentInteraction(Context context) {
        super(context);
    }

    public static CommentInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new CommentInteraction(ctx);
        }
        return _INSTANCE;
    }

    public List<Comment> getComments() {
        CommentDao dataDao = getDaoSession().getCommentDao();
        return dataDao.queryBuilder()
            .orderDesc(CommentDao.Properties.CreatedDate)
            .list();
    }

    public Comment getCommentById(long id) {
        return getDaoSession().getCommentDao()
            .queryBuilder()
            .where(CommentDao.Properties.Id.eq(id))
            .unique();
    }

    public boolean insertOrUpdateComment(Comment Comment) {
        return getDaoSession().getCommentDao().insertOrReplace(Comment) >= 0;
    }

    public boolean insert(Comment Comment) {
        try {
            List<Comment> list = getComments();
            if (list.isEmpty()) {
                return getDaoSession().getCommentDao().insert(Comment) >= 0;
            }
            Comment lastItem = list.get(list.size() - 1);
            Comment.setId(lastItem.getId() + 1);
            return getDaoSession().getCommentDao().insert(Comment) >= 0;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteComment(long id) {
        getDaoSession().getCommentDao().delete(getCommentById(id));
    }
}
