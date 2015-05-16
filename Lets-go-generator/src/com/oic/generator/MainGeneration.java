package com.oic.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

import java.io.File;

public class MainGeneration {
    private static Schema schema;
    private static final String PACKAGE_NAME = "com.oic.bookreminder.models.greendao";
    private static final int VERSION_CODE = 1;
    private static final String DIR_OUTPUT = "../Lets-go-generator-out-ver"+VERSION_CODE+"/src";

    public static void main(String args[]) throws Exception {
        File outputDir = new File(DIR_OUTPUT);
        if(!outputDir.isDirectory()){
            outputDir.mkdirs();
        }

        generate();
    }

    private static void generate() throws Exception {
        schema = new Schema(VERSION_CODE, PACKAGE_NAME);
        schema.enableKeepSectionsByDefault();

        addTables();
        new DaoGenerator().generateAll(schema, DIR_OUTPUT);
    }

    private static void addTables() {

        // Table: User
        Entity user = schema.addEntity("User");

        user.addLongProperty("_id").primaryKey().autoincrement();
        user.addStringProperty("userId");
        user.addStringProperty("accessToken");
        user.addStringProperty("gcmToken");
        user.addStringProperty("displayName");
        user.addStringProperty("fbId");
        user.addStringProperty("fbAccessToken");
        user.addLongProperty("fbExpiredDate");
        user.addStringProperty("fbEmail");
        user.addStringProperty("fbUserName");
        user.addStringProperty("privateEmail");
        user.addStringProperty("avatarUrl");
        user.addBooleanProperty("isActivated");
        user.addIntProperty("emailNotification");
        user.addStringProperty("language");

        // Table: Notifications
        Entity notification = schema.addEntity("Notification");

        notification.addLongProperty("_id").primaryKey();
        notification.addLongProperty("notificationId");
        notification.addStringProperty("type");
        notification.addStringProperty("content");
        notification.addStringProperty("messageData");
        notification.addLongProperty("messageId");
        notification.addStringProperty("thumbnailUrl");
        notification.addLongProperty("createdDate");
        notification.addLongProperty("updatedDate");
        notification.addLongProperty("sortTime");
        notification.addIntProperty("isRead");

        // reference keys
        user.addToMany(notification, notification.addLongProperty("clientUserId").notNull().getProperty());

    }
}