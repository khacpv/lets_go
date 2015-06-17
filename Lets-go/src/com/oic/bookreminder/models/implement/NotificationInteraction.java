package com.oic.bookreminder.models.implement;

import android.content.Context;
import com.oic.bookreminder.models.tables.Notification;

import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class NotificationInteraction extends DbInteraction{
    private static NotificationInteraction _INSTANCE;

    private NotificationInteraction(Context context) {
        super(context);
    }

    public static NotificationInteraction getInstance(Context ctx){
        if(null == _INSTANCE){
            _INSTANCE = new NotificationInteraction(ctx);
        }
        return _INSTANCE;
    }

    public Notification getNotification(long id) {
        return null;
    }

    public List<Notification> getNotifications() {
        return null;
    }

    public boolean insertOrUpdateNotification(Notification notification) {
        return false;
    }

    public boolean deleteNotification(long id) {
        return false;
    }

    public boolean markNotificationAsRead(long id) {
        return false;
    }


}
