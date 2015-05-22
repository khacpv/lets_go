package com.oic.bookreminder.app.addbook;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.addbook.screens.FragmentAddPageCurrent;
import com.oic.bookreminder.app.addbook.screens.FragmentAddPageFinal;
import com.oic.bookreminder.app.addbook.screens.FragmentAddTime;
import com.oic.bookreminder.app.addbook.screens.FragmentAddTitle;
import com.oic.bookreminder.common.BaseActivity;
import com.oic.bookreminder.common.views.image.MakeBlurImage;
import com.oic.bookreminder.vendor.views.viewpager.ParallaxViewPagerIndicator;
import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddBookV2 extends AppFragment{
    RelativeLayout layoutAddBook;

    ParallaxViewPagerIndicator viewPagerAddBook;
    PageIndicator indicatorAddBook;

    AdapterAddBook adapterAddBook;
    ArrayList<AppFragment> fragments = new ArrayList<>();

    AppFragment fragmentAddTitle;
    AppFragment fragmentAddTime;
    AppFragment fragmentAddPageCurrent;
    AppFragment fragmentAddPageFinal;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addbook_v2,container,false);
    }

    @Override
    protected void findControls(View viewParent) {

        layoutAddBook = (RelativeLayout)viewParent.findViewById(R.id.layoutAddBook);
        viewPagerAddBook = (ParallaxViewPagerIndicator)viewParent.findViewById(R.id.frgAddBook);
        indicatorAddBook = (PageIndicator)viewParent.findViewById(R.id.indicatorAddBook);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        Bitmap bg = MakeBlurImage.createBlurImage(getActivity(),R.drawable.parallax_bg);

        fragmentAddTitle = new FragmentAddTitle();
        fragmentAddTime = new FragmentAddTime();
        fragmentAddPageCurrent = new FragmentAddPageCurrent();
        fragmentAddPageFinal = new FragmentAddPageFinal();

        fragments.add(fragmentAddTitle);
        fragments.add(fragmentAddTime);
        fragments.add(fragmentAddPageCurrent);
        fragments.add(fragmentAddPageFinal);

        adapterAddBook = new AdapterAddBook(((BaseActivity)getActivity()).getFragmentMng(), fragments);

        viewPagerAddBook
            .setOverlapPercentage(0.25f)
            .setAdapter(adapterAddBook);

        indicatorAddBook.setOnPageChangeListener(viewPagerAddBook.getPageChangeListener());
        indicatorAddBook.setViewPager(viewPagerAddBook);

        viewPagerAddBook.setBackground(bg);

    }
}
