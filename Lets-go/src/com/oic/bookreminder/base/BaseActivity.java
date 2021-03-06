package com.oic.bookreminder.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by khacpham on 5/17/15.
 */
public abstract class BaseActivity extends FragmentActivity{
    private FragmentManager mFragmentMng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public FragmentManager getFragmentMng(){
        if(null == mFragmentMng){
            mFragmentMng = getSupportFragmentManager();
        }
        return mFragmentMng;
    }

    @Override
    public void onBackPressed() {
        boolean processed = false;
        List<Fragment> fragmentList = mFragmentMng.getFragments();
        for(Fragment fragment: fragmentList){
            if(null == fragment){
                continue;
            }
            if(fragment.isVisible()){
                if(((BaseFragment)fragment).onKeyBack()){
                    processed = processed || true;
                }
            }
        }
        if(processed){
            return;
        }
        super.onBackPressed();
    }

    /**
     * Call .comit() after edit.
     * */
    public FragmentTransaction getFragmentTnx(){
        return getFragmentMng().beginTransaction();
    }
}
