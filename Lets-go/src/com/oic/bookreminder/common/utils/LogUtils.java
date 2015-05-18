package com.oic.bookreminder.common.utils;

import android.util.Log;
import com.oic.bookreminder.config.ConfigApp;

/**
 * Created by khacpham on 5/17/15.
 */
public class LogUtils {
    public static void log(String tag, Object message) {
        if (ConfigApp.DEBUG) Log.w(tag, "" + message);
    }

    public static void logE(Object tag, Object message) {
        if (ConfigApp.DEBUG) Log.e(tag + "", "" + message);
    }

    public static void logE(Object message) {
        if (ConfigApp.DEBUG) Log.e("QUICK LOG", "" + message);
    }

    public static void logK(String tag, Object message) {
        Log.v(tag, "" + message);
    }

    public static void logD(String tag, Object message) {
        if (ConfigApp.DEBUG) Log.d(tag, "" + message);
    }
}
