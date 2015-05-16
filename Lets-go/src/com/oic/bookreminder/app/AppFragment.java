package com.oic.bookreminder.app;

import android.app.Activity;
import android.os.Bundle;
import com.oic.bookreminder.common.BaseFragment;
import com.oic.bookreminder.common.api.IFlowScreen;
import com.oic.bookreminder.models.implement.DbInteraction;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class AppFragment extends BaseFragment{
    protected DbInteraction mDbInteraction;
    protected IFlowScreen mFlowScreen;

    public AppFragment(){
        mDbInteraction = DbInteraction.getInstance(this.getActivity());
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
