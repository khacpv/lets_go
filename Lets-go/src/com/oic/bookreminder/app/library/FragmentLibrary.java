package com.oic.bookreminder.app.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentLibrary extends AppFragment{

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library,container,false);
    }

    @Override
    protected void findControls(View viewParent) {

    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {

    }
}
