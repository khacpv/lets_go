package com.oic.bookreminder.models.tables;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.oic.bookreminder.models.tables.Notification;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table NOTIFICATION.
*/
public class NotificationDao extends AbstractDao<Notification, Long> {

    public static final String TABLENAME = "NOTIFICATION";

    /**
     * Properties of entity Notification.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property NotificationId = new Property(1, Long.class, "notificationId", false, "NOTIFICATION_ID");
        public final static Property Type = new Property(2, String.class, "type", false, "TYPE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property MessageData = new Property(4, String.class, "messageData", false, "MESSAGE_DATA");
        public final static Property MessageId = new Property(5, Long.class, "messageId", false, "MESSAGE_ID");
        public final static Property ThumbnailUrl = new Property(6, String.class, "thumbnailUrl", false, "THUMBNAIL_URL");
        public final static Property CreatedDate = new Property(7, Long.class, "createdDate", false, "CREATED_DATE");
        public final static Property UpdatedDate = new Property(8, Long.class, "updatedDate", false, "UPDATED_DATE");
        public final static Property SortTime = new Property(9, Long.class, "sortTime", false, "SORT_TIME");
        public final static Property IsRead = new Property(10, Integer.class, "isRead", false, "IS_READ");
        public final static Property ClientUserId = new Property(11, long.class, "clientUserId", false, "CLIENT_USER_ID");
    };

    private Query<Notification> user_NotificationListQuery;

    public NotificationDao(DaoConfig config) {
        super(config);
    }
    
    public NotificationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'NOTIFICATION' (" + //
                "'ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NOTIFICATION_ID' INTEGER," + // 1: notificationId
                "'TYPE' TEXT," + // 2: type
                "'CONTENT' TEXT," + // 3: content
                "'MESSAGE_DATA' TEXT," + // 4: messageData
                "'MESSAGE_ID' INTEGER," + // 5: messageId
                "'THUMBNAIL_URL' TEXT," + // 6: thumbnailUrl
                "'CREATED_DATE' INTEGER," + // 7: createdDate
                "'UPDATED_DATE' INTEGER," + // 8: updatedDate
                "'SORT_TIME' INTEGER," + // 9: sortTime
                "'IS_READ' INTEGER," + // 10: isRead
                "'CLIENT_USER_ID' INTEGER NOT NULL );"); // 11: clientUserId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'NOTIFICATION'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Notification entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long notificationId = entity.getNotificationId();
        if (notificationId != null) {
            stmt.bindLong(2, notificationId);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(3, type);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String messageData = entity.getMessageData();
        if (messageData != null) {
            stmt.bindString(5, messageData);
        }
 
        Long messageId = entity.getMessageId();
        if (messageId != null) {
            stmt.bindLong(6, messageId);
        }
 
        String thumbnailUrl = entity.getThumbnailUrl();
        if (thumbnailUrl != null) {
            stmt.bindString(7, thumbnailUrl);
        }
 
        Long createdDate = entity.getCreatedDate();
        if (createdDate != null) {
            stmt.bindLong(8, createdDate);
        }
 
        Long updatedDate = entity.getUpdatedDate();
        if (updatedDate != null) {
            stmt.bindLong(9, updatedDate);
        }
 
        Long sortTime = entity.getSortTime();
        if (sortTime != null) {
            stmt.bindLong(10, sortTime);
        }
 
        Integer isRead = entity.getIsRead();
        if (isRead != null) {
            stmt.bindLong(11, isRead);
        }
        stmt.bindLong(12, entity.getClientUserId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Notification readEntity(Cursor cursor, int offset) {
        Notification entity = new Notification( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // notificationId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // messageData
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // messageId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // thumbnailUrl
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // createdDate
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8), // updatedDate
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // sortTime
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // isRead
            cursor.getLong(offset + 11) // clientUserId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Notification entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNotificationId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMessageData(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMessageId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setThumbnailUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreatedDate(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setUpdatedDate(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        entity.setSortTime(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setIsRead(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setClientUserId(cursor.getLong(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Notification entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Notification entity) {
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
    
    /** Internal query to resolve the "notificationList" to-many relationship of User. */
    public List<Notification> _queryUser_NotificationList(long clientUserId) {
        synchronized (this) {
            if (user_NotificationListQuery == null) {
                QueryBuilder<Notification> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ClientUserId.eq(null));
                user_NotificationListQuery = queryBuilder.build();
            }
        }
        Query<Notification> query = user_NotificationListQuery.forCurrentThread();
        query.setParameter(0, clientUserId);
        return query.list();
    }

}
