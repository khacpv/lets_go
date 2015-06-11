package com.oic.bookreminder.base;

import android.support.v4.app.Fragment;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IFlowScreen {

    /*============= SPLASH ===========================*/

    void onSplash();
    void onSplashToReadingBook(Fragment oldFragment);
    void onSplashToAddbook(Fragment oldFragment);
    void onSplashToLibrary(Fragment oldFragment);
    void onSplashToMainScreen(Fragment oldFragment);

    /*============= ADD NEW BOOK ===========================*/
    void onAddBookToReading(Fragment oldFragment);

    /*============= READING BOOK ===========================*/
    void onReadingToAddBook(Fragment oldFragment);

    /*============= LIBRARY ===========================*/

    /*============= NOTIFICATION ===========================*/

    /*============= MINI GAME ===========================*/

    /*============= SETTING ===========================*/
}
