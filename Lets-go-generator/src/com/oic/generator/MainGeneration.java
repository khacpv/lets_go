package com.oic.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

import java.io.File;

public class MainGeneration {
    private static Schema schema;
    private static final String PACKAGE_NAME = "com.oic.bookreminder.models.tables";
    private static final int VERSION_CODE = 2;
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

        user.addLongProperty("id").primaryKey().autoincrement();
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

        notification.addLongProperty("id").primaryKey().autoincrement();
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

        // Table: Book
        Entity book = schema.addEntity("Book");

        book.addLongProperty("id").primaryKey();
        book.addStringProperty("title");
        book.addStringProperty("author");
        book.addStringProperty("isbn");
        book.addStringProperty("cost");
        book.addIntProperty("totalPages");
        book.addDateProperty("createdDate");

        // Table: BookNotes
        Entity note = schema.addEntity("Note");

        note.addLongProperty("id").primaryKey().autoincrement();
        book.addToMany(note,note.addLongProperty("bookId").notNull().getProperty());
        note.addStringProperty("content");
        note.addDateProperty("createdDate");
        note.addBooleanProperty("complete");
        note.addBooleanProperty("isReading");

        // Table: BookNotes
        Entity readBook = schema.addEntity("Read");

        readBook.addLongProperty("id").primaryKey().autoincrement();
        book.addToMany(readBook, readBook.addLongProperty("bookId").notNull().getProperty());
        readBook.addIntProperty("page");
        readBook.addStringProperty("content");
        readBook.addDateProperty("createdDate");

        // reference keys
        user.addToMany(notification, notification.addLongProperty("clientUserId").notNull().getProperty());
        user.addToMany(book, book.addLongProperty("clientUserId").notNull().getProperty());

    }
}