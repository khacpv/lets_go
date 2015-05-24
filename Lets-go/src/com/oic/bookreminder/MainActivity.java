package com.oic.bookreminder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.addbook.AdapterAddBook;
import com.oic.bookreminder.app.addbook.FragmentAddBookV2;
import com.oic.bookreminder.app.library.FragmentLibrary;
import com.oic.bookreminder.app.readingbook.FragmentReadbook;
import com.oic.bookreminder.app.splash.FragmentSplash;
import com.oic.bookreminder.common.BaseActivity;
import com.oic.bookreminder.common.api.IFlowScreen;
import com.oic.bookreminder.config.ConfigApp;
import com.oic.bookreminder.vendor.views.viewpager.ParallaxViewPager;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IFlowScreen{
    int mainScreenId;
    FrameLayout mainScreen;

    ParallaxViewPager viewPagerAddBook;
    AdapterAddBook adapterAddBook;
    ArrayList<AppFragment> fragments = new ArrayList<>();

    AppFragment fragmentAddTitle;
    AppFragment fragmentAddTime;
    AppFragment fragmentAddPageCurrent;
    AppFragment fragmentAddPageFinal;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        viewPagerAddBook = (ParallaxViewPager)findViewById(R.id.frgAddBook);

        mainScreen = (FrameLayout)findViewById(R.id.layoutMainScreen);
        mainScreenId = R.id.layoutMainScreen;

        ConfigApp.fragmentManager = getSupportFragmentManager();
        onSplash();
    }

    @Override
    public void onSplash() {
        FragmentTransaction transaction = getFragmentTnx();
        transaction.add(mainScreenId,new FragmentSplash(),FragmentSplash.class.getName());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onSplashToReadingBook(Fragment oldFragment) {
        String tag = FragmentReadbook.class.getName();
        FragmentReadbook fragment = (FragmentReadbook)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);

        if(null == fragment){
            fragment = new FragmentReadbook();
            transaction.add(mainScreenId,fragment,tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.addToBackStack(tag);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onSplashToAddbook(Fragment oldFragment) {
        String tag = FragmentAddBookV2.class.getName();
        FragmentAddBookV2 fragment = (FragmentAddBookV2)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

        if(null == fragment){
            fragment = new FragmentAddBookV2();
            transaction.add(mainScreenId,fragment,tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onSplashToLibrary(Fragment oldFragment) {
        String tag = FragmentLibrary.class.getName();
        FragmentLibrary fragment = (FragmentLibrary)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

        if(null == fragment){
            fragment = new FragmentLibrary();
            transaction.add(mainScreenId,fragment,tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onAddBookToReading(Fragment oldFragment) {
        String tag = FragmentReadbook.class.getName();
        FragmentReadbook fragment = (FragmentReadbook)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);

        if(null == fragment){
            fragment = new FragmentReadbook();
            transaction.add(mainScreenId,fragment,tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onReadingToAddBook(Fragment oldFragment) {
        String tag = FragmentAddBookV2.class.getName();
        FragmentAddBookV2 fragment = (FragmentAddBookV2)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

        if(null == fragment){
            fragment = new FragmentAddBookV2();
            transaction.add(mainScreenId,fragment,tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.commitAllowingStateLoss();
    }
}
