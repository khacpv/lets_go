package com.oic.bookreminder.app.addbook.screens;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddTitle extends AppFragment implements ViewPager.OnPageChangeListener{
    public static final int PAGE_ID = 0;

    ImageView pageAddTitlePencil;
    View pageAddTitleBook;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addtitle,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        pageAddTitlePencil = (ImageView)viewParent.findViewById(R.id.pageAddTitlePencil);
        pageAddTitleBook = viewParent.findViewById(R.id.pageAddTitleBook);
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
        if(position == FragmentAddTitle.PAGE_ID){
            YoYo.with(Techniques.Shake)
                .delay(200)
                .duration(1000)
                .playOn(pageAddTitlePencil);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
