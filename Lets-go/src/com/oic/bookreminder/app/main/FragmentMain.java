package com.oic.bookreminder.app.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.library.FragmentLibrary;
import com.oic.bookreminder.app.readingbook.FragmentReadbook;
import com.oic.bookreminder.common.views.viewpager.transform.TabletTransformer;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/29/15.
 */
public class FragmentMain extends AppFragment implements FragmentLibrary.OnBookSelectListener {
    ImageView bookAnimItem;

    ViewPager pagerMain;
    MainAdapter adapter;
    ArrayList<AppFragment> fragments;

    AppFragment fragmentReview;
    AppFragment fragmentReading;
    AppFragment fragmentLibrary;


    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_main,null);
        return parent;
    }

    @Override
    protected void findControls(View viewParent) {
        bookAnimItem = (ImageView)viewParent.findViewById(R.id.bookAnimItem);

        pagerMain = (ViewPager)viewParent.findViewById(R.id.viewPagerMain);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        fragments = new ArrayList<>();

//        fragmentReview = new FragmentReview();
//        fragments.add(fragmentReview);

        fragmentReading = new FragmentReadbook();
        fragments.add(fragmentReading);

//        fragmentLibrary = new FragmentLibrary();
//        fragments.add(fragmentLibrary);
//        ((FragmentLibrary)fragmentLibrary).setOnBookSelectListener(this);

        pagerMain.setPageTransformer(true, new TabletTransformer());

        adapter = new MainAdapter(getActivity().getSupportFragmentManager(),fragments);
        pagerMain.setAdapter(adapter);

        pagerMain.setCurrentItem(1);
    }

    @Override
    public void onBookSelect(View v, Object book) {
        pagerMain.setCurrentItem(1,true);
//
//        v.setDrawingCacheEnabled(true);
//        v.buildDrawingCache();
//
//        Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
//        v.setDrawingCacheEnabled(false);
//
//        int width = bmp.getWidth();
//        int height = bmp.getHeight();
//        int x = (int)v.getX();
//        int y = (int)v.getY();
//
//        bookAnimItem.setImageBitmap(bmp);
//
//        FrameLayout.LayoutParams bookParams = (FrameLayout.LayoutParams)bookAnimItem.getLayoutParams();
//        bookParams.setMargins(x+20,y,x+width,y+height);
//        bookParams.width = width;
//        bookParams.height = height;
//        bookAnimItem.setLayoutParams(bookParams);
//
//
//        bookAnimItem.setVisibility(View.VISIBLE);
//        bookAnimItem.animate().scaleX(1.5F).scaleY(1.5F).setDuration(200).setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                pagerMain.setCurrentItem(1,true);
//                bookAnimItem.setVisibility(View.GONE);
//                bookAnimItem.clearAnimation();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        }).start();
    }
}
