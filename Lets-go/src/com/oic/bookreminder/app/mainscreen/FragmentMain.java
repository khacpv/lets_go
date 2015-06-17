package com.oic.bookreminder.app.mainscreen;

import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.mainscreen.ask.FragmentAsk;
import com.oic.bookreminder.app.mainscreen.comment.FragmentComment;
import com.oic.bookreminder.app.mainscreen.exchange.FragmentExchange;
import com.oic.bookreminder.common.views.CustomActionbar;
import com.oic.bookreminder.common.views.CustomHeader;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentMain extends AppFragment implements CustomActionbar.OnActionbarListener, CustomHeader.OnHeaderListener {
    @InjectView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @InjectView(R.id.left_drawer)
    public RelativeLayout leftDrawer;

    @InjectView(R.id.menu_list)
    public ListView mDrawerList;

    @InjectView(R.id.actionbar)
    CustomActionbar actionbar;

    @InjectView(R.id.customHeader)
    CustomHeader customHeader;

    FragmentComment frgComment;
    FragmentAsk frgAsk;
    FragmentExchange frgExchange;

    BroadcastReceiver searchReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())){
                String text = intent.getStringExtra(SearchManager.QUERY);
                Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        frgComment = new FragmentComment();
        frgAsk = new FragmentAsk();
        frgExchange = new FragmentExchange();

        setCurrentFragment(CustomHeader.TAB.COMMENT);
    }

    @Override
    protected void setEventsToControls(View viewParent) {
        actionbar.setOnActionbarListener(this);
        customHeader.setOnHeaderListener(this);
    }

    public void setCurrentFragment(CustomHeader.TAB tab) {
        AppFragment fragment = frgComment;

        switch (tab){
            case COMMENT:
                fragment = frgComment;
                break;
            case ASK:
                fragment = frgAsk;
                break;
            case EXCHANGE:
                fragment = frgExchange;
                break;
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(searchReceiver, new IntentFilter(Intent.ACTION_SEARCH));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(searchReceiver);
    }

    @Override
    public boolean onKeyBack() {
        if (actionbar.isSearching()) {
            actionbar.showSearch(false);
            return true;
        }
        if(mDrawerLayout.isDrawerOpen(leftDrawer)){
            mDrawerLayout.closeDrawers();
            return true;
        }
        return false;
    }

    @Override
    public void onSearch(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuClick(View v) {
        mDrawerLayout.openDrawer(leftDrawer);
    }

    @Override
    public void onTabChange(View v, int id, CustomHeader.TAB tab) {
        setCurrentFragment(tab);
    }
}
