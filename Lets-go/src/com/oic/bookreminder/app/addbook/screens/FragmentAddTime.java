package com.oic.bookreminder.app.addbook.screens;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddTime extends AppFragment implements ViewPager.OnPageChangeListener{
    public static final int PAGE_ID = 1;

    ImageView pageAddTimeClock;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addtime,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        pageAddTimeClock = (ImageView)viewParent.findViewById(R.id.pageAddTimeClock);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position == FragmentAddTime.PAGE_ID){
            pageAddTimeClock.setVisibility(View.INVISIBLE);
            YoYo.with(Techniques.Tada).delay(200).duration(1000)
                .interpolate(new BounceInterpolator(getActivity(), null))
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        pageAddTimeClock.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .playOn(pageAddTimeClock);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
