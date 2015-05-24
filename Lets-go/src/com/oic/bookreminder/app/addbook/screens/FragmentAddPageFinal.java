package com.oic.bookreminder.app.addbook.screens;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.addbook.FragmentAddBookV2;
import com.oic.bookreminder.models.implement.DbInteraction;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddPageFinal extends AppFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    public static final int PAGE_ID = 2;

    ImageView pageFinalClock;
    ScrollView pageFinalScroll;
    EditText bubbleNumpage;

    ImageView fragmentAddBookButtonEdit;

    FragmentAddBookV2 fragmentParent;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addpagefinal, container, false);
    }

    @Override
    protected void findControls(View viewParent) {
        pageFinalClock = (ImageView) viewParent.findViewById(R.id.pageFinalClock);
        pageFinalScroll = (ScrollView) viewParent.findViewById(R.id.pageFinalScroll);
        bubbleNumpage = (EditText)viewParent.findViewById(R.id.bubbleNumpage);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == FragmentAddPageFinal.PAGE_ID) {
            this.fragmentAddBookButtonEdit = ((FragmentAddBookV2)mFragmentParent).getButtonEdit();
            fragmentAddBookButtonEdit.setOnClickListener(this);

            YoYo.with(Techniques.Shake).delay(200).duration(1000)
                .interpolate(new BounceInterpolator(getActivity(),null))
                .playOn(bubbleNumpage);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void setmFragmentParent(AppFragment fragmentParent) {
        super.setmFragmentParent(fragmentParent);
        this.fragmentParent = (FragmentAddBookV2)fragmentParent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragmentAddBookButtonEdit:
                DbInteraction.getInstance(getActivity()).insert(fragmentParent.book);
                mFlowScreen.onAddBookToReading(mFragmentParent);
                break;
        }
    }
}
