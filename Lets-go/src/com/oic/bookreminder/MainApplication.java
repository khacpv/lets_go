package com.oic.bookreminder;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.oic.bookreminder.common.BaseApplication;
import com.oic.bookreminder.config.ConfigApp;

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
        ConfigApp.SCREEN_WIDTH = size.x;
        ConfigApp.SCREEN_HEIGHT = size.y;
    }


}
