package com.oic.bookreminder.common.api;

import android.support.v4.app.Fragment;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IFlowScreen {

    /*============= SPLASH ===========================*/

    void onSplash();
    void onSplashToReadingBook(Fragment oldFragment);
    void onSplashToAddbook(Fragment oldFragment);

    /*============= ADD NEW BOOK ===========================*/

    /*============= LIBRARY ===========================*/

    /*============= NOTIFICATION ===========================*/

    /*============= MINI GAME ===========================*/

    /*============= SETTING ===========================*/
}
