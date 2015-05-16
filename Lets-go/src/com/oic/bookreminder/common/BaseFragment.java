package com.oic.bookreminder.common;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflateLayout(inflater, container, savedInstanceState);

        findControls(view);

        setEventsToControls(view);

        initializeDefaultData();

        return view;
    }

    /**
     * Inflate the target layout of fragment. U don't need to override
     * onCreateView
     */
    protected abstract View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * Find all views by id
     */
    protected abstract void findControls(View viewParent);

    /**
     * Set events to all wanted controls
     */
    protected abstract void setEventsToControls(View viewParent);

    /**
     * Initialize default data
     */
    protected abstract void initializeDefaultData();
}
