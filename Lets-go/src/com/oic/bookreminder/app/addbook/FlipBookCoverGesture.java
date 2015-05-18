package com.oic.bookreminder.app.addbook;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oic.bookreminder.common.utils.LogUtils;
import com.oic.bookreminder.common.views.anims.Rotate3dAnimation;

/**
 * Created by khacpham on 5/19/15.
 */
public class FlipBookCoverGesture implements GestureDetector.OnGestureListener {
    Context context;
    RelativeLayout view;
    Animation.AnimationListener listener;

    public FlipBookCoverGesture(Context context,RelativeLayout v){
        this.context = context;
        this.view = v;
    }

    public void setOnAnimationListener(Animation.AnimationListener listener){
        this.listener = listener;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        ViewGroup.MarginLayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
//        layoutParams.rightMargin += (int)distanceX;
//
//        view.setLayoutParams(layoutParams);
//        view.requestLayout();
//        view.invalidate();

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        LogUtils.logE("onFling book cover");
        float fromDegrees=0;
        float toDegrees=-270;
        float centerX=0;
        float centerY=0;
        float depthZ=0;
        boolean horizontal=false;
        boolean reverse=false;
        Rotate3dAnimation animation = new Rotate3dAnimation(fromDegrees,toDegrees,centerX,centerY,depthZ,horizontal,reverse);
        animation.setDuration(3000);

        animation.setAnimationListener(listener);
        view.startAnimation(animation);
        return true;
    }
}
