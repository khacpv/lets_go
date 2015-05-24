package com.oic.bookreminder.app.readingbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.common.views.ReadBookView;
import com.oic.bookreminder.common.views.ShelveView;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentReadbook extends AppFragment{
    ShelveView fragmentReadBookShelveBook;
    ReadBookView fragmentReadBookView;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_readbook,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        fragmentReadBookShelveBook = (ShelveView)viewParent.findViewById(R.id.fragmentReadBookShelveBook);
        fragmentReadBookView = (ReadBookView)viewParent.findViewById(R.id.fragmentReadBookView);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        if(null != fragmentReadBookView.fragmentReadBookClock) {
            fragmentReadBookView.setComplete(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onKeyBack() {
        if(!fragmentReadBookView.isComplete()){
            fragmentReadBookView.setComplete(true);
            return true;
        }
        return super.onKeyBack();
    }
}
