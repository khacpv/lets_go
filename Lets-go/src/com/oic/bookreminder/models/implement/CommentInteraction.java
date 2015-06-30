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

    public List<Comment> getCommentByBookId(long bookId) {
        CommentDao dataDao = getDaoSession().getCommentDao();
        return dataDao.queryBuilder()
            .where(CommentDao.Properties.BookId.eq(bookId))
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

    public boolean insert(Comment comment) {
        return getDaoSession().getCommentDao().insert(comment) >= 0;
    }

    public void deleteComment(long id) {
        getDaoSession().getCommentDao().delete(getCommentById(id));
    }
}
