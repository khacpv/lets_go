package com.oic.bookreminder;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.oic.bookreminder.base.BaseApplication;
import com.oic.bookreminder.config.ConfigApp;
import com.oic.bookreminder.models.implement.TableInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.Comment;
import com.oic.bookreminder.models.tables.User;
import com.oic.bookreminder.models.tables.UserBook;

import java.io.File;
import java.sql.Date;
import java.util.List;

/**
 * Created by khacpham on 5/16/15.
 */
public class MainApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            display.getSize(size);
        } else {
            size.set(display.getWidth(), display.getHeight());
        }
        GlobalStorage.SCREEN_WIDTH = size.x;
        GlobalStorage.SCREEN_HEIGHT = size.y;

        initImageLoader();

        GlobalStorage.USER = TableInteraction.getInstance(this).getLoggedInUser();

        if(ConfigApp.DEBUG){
            initDataDefault();
        }
    }

    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisc(true)
            .build();

        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        cacheDir.mkdirs();


        ImageLoaderConfiguration config = new
            ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();

        ImageLoader.getInstance().init(config);
    }

    private void initDataDefault(){
        // User
        User user = new User(1L);
        User user2 = new User(2L);
        if(null == GlobalStorage.USER){
            GlobalStorage.USER = new User(0L);
            GlobalStorage.USER.setAvatarUrl("http://storage.oicmap.com/blob/warrent.jpg");
            GlobalStorage.USER.setDisplayName("Reader User");
            GlobalStorage.USER.setIsActivated(true);
            GlobalStorage.USER.setUserId(0L);
            TableInteraction.getInstance(this).insertUser(GlobalStorage.USER);


            user.setAvatarUrl("http://storage.oicmap.com/blob/lucy.jpg");
            user.setDisplayName("Lucy");
            user.setIsActivated(false);
            user.setUserId(1L);
            TableInteraction.getInstance(this).insertUser(user);


            user2.setAvatarUrl("http://storage.oicmap.com/blob/warrent.jpg");
            user2.setDisplayName("Warent");
            user2.setIsActivated(false);
            user2.setUserId(2L);
            TableInteraction.getInstance(this).insertUser(user2);
        }

        String[] bookTitle = {
            "Traction",
            "Running Lean",
            "Lean Analytics"
        };
        String[] bookDesc = {
            "Traction: A Startup Guide to Getting Customers",
            "Running Lean: Iterate from Plan A to a Plan That Works",
            "Lean Analytics: Use Data to Build a Better Startup Faster"
        };
        String[] bookAuthor = {
            "Justin Mares",
            "Ash Maurya",
            "Alistair Croll"
        };
        String[] bookThumb = {
            "http://storage.oicmap.com/blob/traction.png",
            "http://storage.oicmap.com/blob/running_lean.png",
            "http://storage.oicmap.com/blob/lean_analytics.png"
        };

        // Book
        List<Book> book1 = TableInteraction.getInstance(this).getBooks();
        if(null == book1 || book1.isEmpty()){

            for(int i=0;i<bookTitle.length;i++) {
                Book book = new Book((long)i);
                book.setBookId((long) i);
                book.setCreatedDate(new Date(System.currentTimeMillis()));
                book.setTitle(bookTitle[i]);
                book.setLikeNumber(i);
                book.setCommentNumber(2);
                book.setTotalPages(0);
                book.setAuthor(bookAuthor[i]);
                book.setDescription(bookDesc[i]);
                book.setThumbnail(bookThumb[i]);

                TableInteraction.getInstance(this).insertBook(book);
            }
        }

        // USERBOOK
        List<UserBook> userBook = TableInteraction.getInstance(this).getUserBook();
        if(null == userBook || userBook.isEmpty()){
            UserBook userBook1 = new UserBook(0L);
            userBook1.setUserId(GlobalStorage.USER.getUserId());
            userBook1.setBookId(0L);
            userBook1.setQuantity(1);
            TableInteraction.getInstance(this).insertUserBook(userBook1);

            userBook1 = new UserBook(1L);
            userBook1.setUserId(GlobalStorage.USER.getUserId());
            userBook1.setBookId(1L);
            userBook1.setQuantity(1);
            TableInteraction.getInstance(this).insertUserBook(userBook1);
        }

        // COMMENT
        List<Comment> comments = TableInteraction.getInstance(this).getComments();
        if(null == comments || comments.isEmpty()) {
            Comment comment = new Comment();
            comment.setBookId(0L);
            comment.setBookTitle(bookTitle[0]);
            comment.setUserId(2L);
            comment.setUserName(user2.getDisplayName());
            comment.setContent("Great book. Must to read");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);

            comment = new Comment();
            comment.setBookId(1L);
            comment.setBookTitle(bookTitle[1]);
            comment.setUserId(1L);
            comment.setUserName(user.getDisplayName());
            comment.setContent("I love this book");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);

            comment = new Comment();
            comment.setBookId(2L);
            comment.setBookTitle(bookTitle[2]);
            comment.setUserId(2L);
            comment.setUserName(user2.getDisplayName());
            comment.setContent("Must read now!");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);

            comment = new Comment();
            comment.setBookId(1L);
            comment.setBookTitle(bookTitle[1]);
            comment.setUserId(1L);
            comment.setUserName(user.getDisplayName());
            comment.setContent("Great book. Must to read");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);

            comment = new Comment();
            comment.setBookId(0L);
            comment.setBookTitle(bookTitle[0]);
            comment.setUserId(2L);
            comment.setUserName(user2.getDisplayName());
            comment.setContent("I love this book");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);

            comment = new Comment();
            comment.setBookId(2L);
            comment.setBookTitle(bookTitle[2]);
            comment.setUserId(1L);
            comment.setUserName(user.getDisplayName());
            comment.setContent("Must read now!");
            comment.setCreatedDate(new Date(System.currentTimeMillis()));
            TableInteraction.getInstance(this).insertComment(comment);
        }
    }
}
