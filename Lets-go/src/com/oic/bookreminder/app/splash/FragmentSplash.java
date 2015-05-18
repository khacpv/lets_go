package com.oic.bookreminder.app.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentSplash extends AppFragment{

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash,container, false);
        return view;
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mFlowScreen.onSplashToAddbook(FragmentSplash.this);
            }
        },1500);
    }
}
