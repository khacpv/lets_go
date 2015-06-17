package com.oic.bookreminder.base;

import android.support.v4.app.Fragment;

/**
 * Created by khacpham on 5/17/15.
 */
public interface IFlowScreen {

    /*============= SPLASH ===========================*/

    /**
     * invoke when start MainActivity
     * */
    void onSplash();

    /**
     * Default: after splash is mainScreen
     * */
    void onSplashToMainScreen(Fragment oldFragment);

    /*============= NOTIFICATION ===========================*/

    /*============= MINI GAME ===========================*/

    /*============= SETTING ===========================*/
}
