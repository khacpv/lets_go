package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.api.IDbInteraction;

/**
 * Created by khacpham on 6/17/15.
 */
public class DbFactory {

    public static enum DB_TYPE {
        USER, NOTIFICATION, BOOK, COMMENT, ASK, EXCHANGE, USERBOOK
    };

    public static IDbInteraction getDbInteraction(Context context, DB_TYPE type){
        switch (type){
            case USER:
                return UserInteraction.getInstance(context);
            case NOTIFICATION:
                return NotificationInteraction.getInstance(context);
            case BOOK:
                return BookInteraction.getInstance(context);
            case COMMENT:
                return CommentInteraction.getInstance(context);
            case ASK:
                return AskInteraction.getInstance(context);
            case EXCHANGE:
                return ExchangeInteraction.getInstance(context);
            case USERBOOK:
                return UserBookInteraction.getInstance(context);
        }
        return null;
    }


}
