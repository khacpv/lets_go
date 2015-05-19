package com.oic.bookreminder.app.addbook;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.vendor.anim.Rotate3dAnimation;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentAddbook extends AppFragment implements View.OnTouchListener, Animation.AnimationListener {
    RelativeLayout layoutAddBook;
    RelativeLayout layoutAddPage;
    GestureDetectorCompat flipBookGesture;
    FlipBookCoverGesture gestureListener;

    boolean animating = false;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addbook,container,false);
    }

    @Override
    public boolean onKeyBack() {
        if(layoutAddBook.getVisibility() == View.VISIBLE){
            return false;
        }
        else if(layoutAddPage.getVisibility() == View.VISIBLE){
            animCloseBook();
            return true;
        }
        else if(animating){
            return true;
        }

        return true;
    }

    @Override
    protected void findControls(View viewParent) {
        layoutAddBook = (RelativeLayout)viewParent.findViewById(R.id.layoutAddBook);
        layoutAddPage = (RelativeLayout)viewParent.findViewById(R.id.layoutAddPage);
    }

    @Override
    protected void setEventsToControls(View viewParent) {
        layoutAddBook.setOnTouchListener(this);
        layoutAddPage.setOnTouchListener(this);
    }

    @Override
    protected void initializeDefaultData() {
        gestureListener = new FlipBookCoverGesture(this,layoutAddBook);
        flipBookGesture = new GestureDetectorCompat(this.getActivity(),gestureListener);

        gestureListener.setOnAnimationListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(flipBookGesture.onTouchEvent(event)){
            return true;
        }
        return false;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        animating = true;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        animating = false;
        layoutAddBook.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void animOpenBook(){
        layoutAddBook.setVisibility(View.VISIBLE);
        layoutAddBook.requestLayout();
        layoutAddBook.invalidate();

        float fromDegrees=0;
        float toDegrees=-80;
        float centerX=0;
        float centerY=0;
        float depthZ=0;
        boolean horizontal=false;
        boolean reverse=false;
        Rotate3dAnimation animation = new Rotate3dAnimation(fromDegrees,toDegrees,centerX,centerY,depthZ,horizontal,reverse);

        Animation alpha = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);

        AnimationSet set = new AnimationSet(getActivity(),null);
        set.addAnimation(animation);
        set.addAnimation(alpha);

        set.setDuration(500);

        set.setAnimationListener(this);
        layoutAddBook.startAnimation(set);
    }

    public void animCloseBook(){
        layoutAddBook.setVisibility(View.VISIBLE);
        layoutAddBook.requestLayout();
        layoutAddBook.invalidate();

        float fromDegrees=-80;
        float toDegrees=0;
        float centerX=0;
        float centerY=0;
        float depthZ=0;
        boolean horizontal=false;
        boolean reverse=false;
        Rotate3dAnimation animation = new Rotate3dAnimation(fromDegrees,toDegrees,centerX,centerY,depthZ,horizontal,reverse);

        Animation alpha = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);

        AnimationSet set = new AnimationSet(getActivity(), null);
        set.addAnimation(animation);
        set.addAnimation(alpha);

        set.setDuration(500);

        layoutAddBook.startAnimation(set);
    }
}
