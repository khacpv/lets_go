package com.oic.bookreminder.app.addbook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.oic.bookreminder.app.AppFragment;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/21/15.
 */
public class AdapterAddBook extends FragmentPagerAdapter{
    ArrayList<AppFragment> fragments = new ArrayList<>();

    public AdapterAddBook(FragmentManager fm, ArrayList<AppFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "fragment title";
    }
}
