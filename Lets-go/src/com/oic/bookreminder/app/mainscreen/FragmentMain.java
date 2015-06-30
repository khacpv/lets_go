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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.oic.bookreminder.GlobalStorage;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.mainscreen.comment.FragmentComment;
import com.oic.bookreminder.app.mainscreen.commentdetail.FragmentCommentDetail;
import com.oic.bookreminder.app.mainscreen.exchange.FragmentExchange;
import com.oic.bookreminder.app.mainscreen.menu.MenuHeaderView;
import com.oic.bookreminder.app.mainscreen.suggest.FragmentSuggest;
import com.oic.bookreminder.common.views.CustomActionbar;
import com.oic.bookreminder.common.views.CustomHeader;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentMain extends AppFragment implements CustomActionbar.OnActionbarListener, CustomHeader.OnHeaderListener {
    public static FragmentMain FRG_MAIN;

    @InjectView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @InjectView(R.id.left_drawer)
    public RelativeLayout leftDrawer;

    @InjectView(R.id.menu_list)
    public RelativeLayout mMenuList;

    @InjectView(R.id.actionbar)
    CustomActionbar actionbar;

    @InjectView(R.id.customHeader)
    CustomHeader customHeader;

    @InjectView(R.id.menu_header)
    MenuHeaderView menuHeader;

    @InjectView(R.id.tvAboutMe)
    TextView tvAboutMe;

    @InjectView(R.id.tvMyBook)
    TextView tvMyBook;

    @InjectView(R.id.tvSavedQuote)
    TextView tvSavedQuote;

    @InjectView(R.id.tvMyGroup)
    TextView tvMyGroup;

    @InjectView(R.id.tvChallenge)
    TextView tvChallenge;

    @InjectView(R.id.tvSetting)
    TextView tvSetting;

    @InjectView(R.id.tvRateReview)
    TextView tvRateReview;

    FragmentComment frgComment;
    FragmentCommentDetail frgCommentDetail;
    FragmentSuggest frgAsk;
    FragmentExchange frgExchange;

    BroadcastReceiver searchReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())){
                if(getCurrentFragment() instanceof CustomActionbar.OnSearchable) {
                    String text = intent.getStringExtra(SearchManager.QUERY);
                    CustomHeader.TAB tab = customHeader.getCurrentTab();
                    ((CustomActionbar.OnSearchable) getCurrentFragment()).onSearch(text);
                }
                else if(getCurrentFragment() instanceof FragmentCommentDetail){
                    String text = intent.getStringExtra(SearchManager.QUERY);
                    CustomHeader.TAB tab = customHeader.getCurrentTab();
                    ((FragmentCommentDetail) getCurrentFragment()).onSearch(text);
                }
            }
        }
    };

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        FRG_MAIN = this;
        frgComment = new FragmentComment();
        frgAsk = new FragmentSuggest();
        frgExchange = new FragmentExchange();
        frgCommentDetail = new FragmentCommentDetail();

        setCurrentFragment(CustomHeader.TAB.COMMENT);

        ImageLoader.getInstance().displayImage(GlobalStorage.USER.getAvatarUrl(), menuHeader.avatar);
        menuHeader.tvUsername.setText(GlobalStorage.USER.getDisplayName());
        menuHeader.tvLevel.setText("Book worm");
    }

    @Override
    protected void setEventsToControls(View viewParent) {
        actionbar.setOnActionbarListener(this);
        customHeader.setOnHeaderListener(this);
    }

    public void setCurrentFragment(CustomHeader.TAB tab) {
        actionbar.setTitle(getString(R.string.logo_text_2));
        customHeader.setCurrentTabFix(tab);
        AppFragment fragment = frgComment;

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (tab){
            case COMMENT:
                fragment = frgComment;
                break;
            case COMMENT_DETAIL:
                actionbar.setTitle(GlobalStorage.BOOK.getTitle());
                fragment = frgCommentDetail;
                transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
                break;
            case ASK:
                fragment = frgAsk;
                break;
            case EXCHANGE:
                fragment = frgExchange;
                break;
        }



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
        if (customHeader.getCurrentTab() == CustomHeader.TAB.COMMENT_DETAIL){
            setCurrentFragment(CustomHeader.TAB.COMMENT);
            return true;
        }
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

    public AppFragment getCurrentFragment(){
        switch (customHeader.getCurrentTab()){
            case COMMENT:
                return frgComment;
            case ASK:
                return frgAsk;
            case EXCHANGE:
                return frgExchange;
            case COMMENT_DETAIL:
                return frgCommentDetail;
        }
        return frgComment;
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
