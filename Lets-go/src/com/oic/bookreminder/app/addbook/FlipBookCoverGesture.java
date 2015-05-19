package com.oic.bookreminder.app.addbook;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oic.bookreminder.common.utils.LogUtils;

/**
 * Created by khacpham on 5/19/15.
 */
public class FlipBookCoverGesture implements GestureDetector.OnGestureListener {
    FragmentAddbook fragmentAddbook;
    RelativeLayout view;
    Animation.AnimationListener listener;

    public FlipBookCoverGesture(FragmentAddbook fragmentAddbook,RelativeLayout v){
        this.fragmentAddbook = fragmentAddbook;
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
        if(velocityX>=0){
            fragmentAddbook.animCloseBook();
            return false;
        }
        LogUtils.logE("onFling book cover");
        fragmentAddbook.animOpenBook();
        return true;
    }
}
