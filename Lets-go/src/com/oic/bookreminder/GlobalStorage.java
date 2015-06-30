package com.oic.bookreminder;

import android.support.v4.app.FragmentManager;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.models.tables.User;

/**
 * Created by khacpham on 6/20/15.
 */
public class GlobalStorage {
    public static User USER;

    public static int SCREEN_WIDTH = 0;
    public static int SCREEN_HEIGHT = 0;

    public static FragmentManager fragmentManager;

    public static Book BOOK;
}
