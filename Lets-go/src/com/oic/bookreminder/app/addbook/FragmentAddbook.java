package com.oic.bookreminder.app.addbook;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentAddbook extends AppFragment implements View.OnTouchListener, Animation.AnimationListener {
    RelativeLayout layoutAddBook;
    GestureDetectorCompat flipBookGesture;
    FlipBookCoverGesture gestureListener;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addbook,container,false);
    }



    @Override
    protected void findControls(View viewParent) {
        layoutAddBook = (RelativeLayout)viewParent.findViewById(R.id.layoutAddBook);
    }

    @Override
    protected void setEventsToControls(View viewParent) {
        layoutAddBook.setOnTouchListener(this);
    }

    @Override
    protected void initializeDefaultData() {
        gestureListener = new FlipBookCoverGesture(this.getActivity(),layoutAddBook);
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

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        layoutAddBook.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
