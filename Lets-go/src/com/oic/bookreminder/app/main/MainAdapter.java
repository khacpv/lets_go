package com.oic.bookreminder.app.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.oic.bookreminder.app.AppFragment;

import java.util.List;

/**
 * Created by khacpham on 5/29/15.
 */
public class MainAdapter extends FragmentPagerAdapter {
    List<AppFragment> fragments;

    public MainAdapter(FragmentManager fm, List<AppFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
