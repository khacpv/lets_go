package com.oic.bookreminder.models.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.oic.bookreminder.models.tables.Comment;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COMMENT.
*/
public class CommentDao extends AbstractDao<Comment, Long> {

    public static final String TABLENAME = "COMMENT";

    /**
     * Properties of entity Comment.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property UserId = new Property(1, Long.class, "userId", false, "USER_ID");
        public final static Property UserName = new Property(2, String.class, "userName", false, "USER_NAME");
        public final static Property BookId = new Property(3, Long.class, "bookId", false, "BOOK_ID");
        public final static Property BookTitle = new Property(4, String.class, "bookTitle", false, "BOOK_TITLE");
        public final static Property Content = new Property(5, String.class, "content", false, "CONTENT");
        public final static Property Image = new Property(6, String.class, "image", false, "IMAGE");
        public final static Property Link = new Property(7, String.class, "link", false, "LINK");
        public final static Property CreatedDate = new Property(8, java.util.Date.class, "createdDate", false, "CREATED_DATE");
    };


    public CommentDao(DaoConfig config) {
        super(config);
    }
    
    public CommentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COMMENT' (" + //
                "'ID' INTEGER PRIMARY KEY ," + // 0: id
                "'USER_ID' INTEGER," + // 1: userId
                "'USER_NAME' TEXT," + // 2: userName
                "'BOOK_ID' INTEGER," + // 3: bookId
                "'BOOK_TITLE' TEXT," + // 4: bookTitle
                "'CONTENT' TEXT," + // 5: content
                "'IMAGE' TEXT," + // 6: image
                "'LINK' TEXT," + // 7: link
                "'CREATED_DATE' INTEGER);"); // 8: createdDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COMMENT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Comment entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(2, userId);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        Long bookId = entity.getBookId();
        if (bookId != null) {
            stmt.bindLong(4, bookId);
        }
 
        String bookTitle = entity.getBookTitle();
        if (bookTitle != null) {
            stmt.bindString(5, bookTitle);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(7, image);
        }
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(8, link);
        }
 
        java.util.Date createdDate = entity.getCreatedDate();
        if (createdDate != null) {
            stmt.bindLong(9, createdDate.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Comment readEntity(Cursor cursor, int offset) {
        Comment entity = new Comment( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // bookId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // bookTitle
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // content
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // image
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // link
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // createdDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Comment entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBookId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setBookTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setContent(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setImage(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLink(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCreatedDate(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Comment entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Comment entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
