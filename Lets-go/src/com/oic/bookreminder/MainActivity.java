package com.oic.bookreminder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import com.oic.bookreminder.app.addbook.FragmentAddbook;
import com.oic.bookreminder.app.library.FragmentLibrary;
import com.oic.bookreminder.app.readingbook.FragmentReadbook;
import com.oic.bookreminder.app.splash.FragmentSplash;
import com.oic.bookreminder.common.BaseActivity;
import com.oic.bookreminder.common.api.IFlowScreen;

public class MainActivity extends BaseActivity implements IFlowScreen{
    int mainScreenId;
    FrameLayout mainScreen;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mainScreen = (FrameLayout)findViewById(R.id.layoutMainScreen);
        mainScreenId = R.id.layoutMainScreen;

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
        String tag = FragmentAddbook.class.getName();
        FragmentAddbook fragment = (FragmentAddbook)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

        if(null == fragment){
            fragment = new FragmentAddbook();
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
}
