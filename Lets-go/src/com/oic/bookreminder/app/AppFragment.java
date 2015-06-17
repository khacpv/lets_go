package com.oic.bookreminder.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.oic.bookreminder.base.BaseFragment;
import com.oic.bookreminder.base.IFlowScreen;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class AppFragment extends BaseFragment{
    protected IFlowScreen mFlowScreen;
    protected Handler mHandler;
    protected AppFragment mFragmentParent;

    public AppFragment(){
        mHandler = new Handler();
    }

    public void setmFragmentParent(AppFragment fragment){
        this.mFragmentParent = fragment;
    }

    public AppFragment(AppFragment parent){
        this.mFragmentParent = parent;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mFlowScreen = (IFlowScreen)getActivity();
    }
}
