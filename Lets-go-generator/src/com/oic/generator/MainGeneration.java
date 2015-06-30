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
        user.addLongProperty("userId");
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

        book.addLongProperty("id").primaryKey().autoincrement();
        book.addLongProperty("bookId");
        book.addStringProperty("title");
        book.addStringProperty("author");
        book.addStringProperty("isbn10");
        book.addStringProperty("isbn13");
        book.addStringProperty("cost");
        book.addIntProperty("totalPages");
        book.addDateProperty("createdDate");
        book.addIntProperty("likeNumber");
        book.addIntProperty("commentNumber");
        book.addStringProperty("thumbnail");
        book.addStringProperty("description");

        // Table: Comment
        Entity comment = schema.addEntity("Comment");

        comment.addLongProperty("id").primaryKey();
        comment.addLongProperty("userId");
        comment.addStringProperty("userName");
        comment.addLongProperty("bookId");
        comment.addStringProperty("bookTitle");
        comment.addStringProperty("content");
        comment.addStringProperty("image");
        comment.addStringProperty("link");
        comment.addDateProperty("createdDate");

        // Table: Suggest
        Entity suggest = schema.addEntity("Suggest");

        suggest.addLongProperty("id").primaryKey();
        suggest.addLongProperty("bookId");
        suggest.addStringProperty("bookTitle");
        suggest.addStringProperty("thumbnail");
        suggest.addStringProperty("author");
        suggest.addStringProperty("content");

        // Table: Exchange
        Entity exchange = schema.addEntity("Exchange");

        exchange.addLongProperty("id").primaryKey();
        exchange.addLongProperty("userId");
        exchange.addStringProperty("userName");
        exchange.addLongProperty("bookId");
        exchange.addStringProperty("bookTitle");
        exchange.addStringProperty("content");
        exchange.addDateProperty("createdDate");

        // Table: User-Book
        Entity userBook = schema.addEntity("UserBook");

        userBook.addLongProperty("id").primaryKey();
        userBook.addLongProperty("userId");
        userBook.addLongProperty("bookId");
        userBook.addIntProperty("quantity");
    }
}