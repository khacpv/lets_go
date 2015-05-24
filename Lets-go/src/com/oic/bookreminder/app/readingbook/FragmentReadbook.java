package com.oic.bookreminder.app.readingbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.common.views.BubleNumPageView;
import com.oic.bookreminder.common.views.ClockDigitalView;
import com.oic.bookreminder.common.views.ShelveView;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentReadbook extends AppFragment{
    ShelveView fragmentReadBookShelveBook;
    BubleNumPageView fragmentReadBookNumPage;
    ClockDigitalView fragmentReadBookClock;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_readbook,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        fragmentReadBookShelveBook = (ShelveView)viewParent.findViewById(R.id.fragmentReadBookShelveBook);
        fragmentReadBookNumPage = (BubleNumPageView)viewParent.findViewById(R.id.fragmentReadBookNumPage);
        fragmentReadBookClock = (ClockDigitalView)viewParent.findViewById(R.id.fragmentReadBookClock);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        fragmentReadBookClock.setFragmentManager(getFragmentManager());
    }
}
