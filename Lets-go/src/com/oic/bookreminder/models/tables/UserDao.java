package com.oic.bookreminder.models.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property UserId = new Property(1, String.class, "userId", false, "USER_ID");
        public final static Property AccessToken = new Property(2, String.class, "accessToken", false, "ACCESS_TOKEN");
        public final static Property GcmToken = new Property(3, String.class, "gcmToken", false, "GCM_TOKEN");
        public final static Property DisplayName = new Property(4, String.class, "displayName", false, "DISPLAY_NAME");
        public final static Property FbId = new Property(5, String.class, "fbId", false, "FB_ID");
        public final static Property FbAccessToken = new Property(6, String.class, "fbAccessToken", false, "FB_ACCESS_TOKEN");
        public final static Property FbExpiredDate = new Property(7, Long.class, "fbExpiredDate", false, "FB_EXPIRED_DATE");
        public final static Property FbEmail = new Property(8, String.class, "fbEmail", false, "FB_EMAIL");
        public final static Property FbUserName = new Property(9, String.class, "fbUserName", false, "FB_USER_NAME");
        public final static Property PrivateEmail = new Property(10, String.class, "privateEmail", false, "PRIVATE_EMAIL");
        public final static Property AvatarUrl = new Property(11, String.class, "avatarUrl", false, "AVATAR_URL");
        public final static Property IsActivated = new Property(12, Boolean.class, "isActivated", false, "IS_ACTIVATED");
        public final static Property EmailNotification = new Property(13, Integer.class, "emailNotification", false, "EMAIL_NOTIFICATION");
        public final static Property Language = new Property(14, String.class, "language", false, "LANGUAGE");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'USER_ID' TEXT," + // 1: userId
                "'ACCESS_TOKEN' TEXT," + // 2: accessToken
                "'GCM_TOKEN' TEXT," + // 3: gcmToken
                "'DISPLAY_NAME' TEXT," + // 4: displayName
                "'FB_ID' TEXT," + // 5: fbId
                "'FB_ACCESS_TOKEN' TEXT," + // 6: fbAccessToken
                "'FB_EXPIRED_DATE' INTEGER," + // 7: fbExpiredDate
                "'FB_EMAIL' TEXT," + // 8: fbEmail
                "'FB_USER_NAME' TEXT," + // 9: fbUserName
                "'PRIVATE_EMAIL' TEXT," + // 10: privateEmail
                "'AVATAR_URL' TEXT," + // 11: avatarUrl
                "'IS_ACTIVATED' INTEGER," + // 12: isActivated
                "'EMAIL_NOTIFICATION' INTEGER," + // 13: emailNotification
                "'LANGUAGE' TEXT);"); // 14: language
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(2, userId);
        }
 
        String accessToken = entity.getAccessToken();
        if (accessToken != null) {
            stmt.bindString(3, accessToken);
        }
 
        String gcmToken = entity.getGcmToken();
        if (gcmToken != null) {
            stmt.bindString(4, gcmToken);
        }
 
        String displayName = entity.getDisplayName();
        if (displayName != null) {
            stmt.bindString(5, displayName);
        }
 
        String fbId = entity.getFbId();
        if (fbId != null) {
            stmt.bindString(6, fbId);
        }
 
        String fbAccessToken = entity.getFbAccessToken();
        if (fbAccessToken != null) {
            stmt.bindString(7, fbAccessToken);
        }
 
        Long fbExpiredDate = entity.getFbExpiredDate();
        if (fbExpiredDate != null) {
            stmt.bindLong(8, fbExpiredDate);
        }
 
        String fbEmail = entity.getFbEmail();
        if (fbEmail != null) {
            stmt.bindString(9, fbEmail);
        }
 
        String fbUserName = entity.getFbUserName();
        if (fbUserName != null) {
            stmt.bindString(10, fbUserName);
        }
 
        String privateEmail = entity.getPrivateEmail();
        if (privateEmail != null) {
            stmt.bindString(11, privateEmail);
        }
 
        String avatarUrl = entity.getAvatarUrl();
        if (avatarUrl != null) {
            stmt.bindString(12, avatarUrl);
        }
 
        Boolean isActivated = entity.getIsActivated();
        if (isActivated != null) {
            stmt.bindLong(13, isActivated ? 1l: 0l);
        }
 
        Integer emailNotification = entity.getEmailNotification();
        if (emailNotification != null) {
            stmt.bindLong(14, emailNotification);
        }
 
        String language = entity.getLanguage();
        if (language != null) {
            stmt.bindString(15, language);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // accessToken
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // gcmToken
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // displayName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // fbId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // fbAccessToken
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // fbExpiredDate
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // fbEmail
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // fbUserName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // privateEmail
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // avatarUrl
            cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0, // isActivated
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // emailNotification
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14) // language
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAccessToken(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGcmToken(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDisplayName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFbId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFbAccessToken(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setFbExpiredDate(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setFbEmail(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFbUserName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPrivateEmail(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAvatarUrl(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setIsActivated(cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0);
        entity.setEmailNotification(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setLanguage(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
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
