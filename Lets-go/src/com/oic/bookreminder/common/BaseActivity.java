package com.oic.bookreminder.common;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.oic.bookreminder.models.implement.DbInteraction;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class BaseActivity extends FragmentActivity{
    private FragmentManager mFragmentMng;
    protected DbInteraction mDbInteraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDbInteraction = DbInteraction.getInstance(this);
    }

    public FragmentManager getFragmentMng(){
        if(null == mFragmentMng){
            mFragmentMng = getSupportFragmentManager();
        }
        return mFragmentMng;
    }

    /**
     * Call .comit() after edit.
     * */
    public FragmentTransaction getFragmentTnx(){
        return getFragmentMng().beginTransaction();
    }
}
