package com.oic.bookreminder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import com.oic.bookreminder.app.mainscreen.FragmentMain;
import com.oic.bookreminder.app.splash.FragmentSplash;
import com.oic.bookreminder.base.BaseActivity;
import com.oic.bookreminder.base.IFlowScreen;

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
        setContentView(R.layout.main_activity);

        mainScreen = (FrameLayout)findViewById(R.id.layoutMainScreen);
        mainScreenId = R.id.layoutMainScreen;

        GlobalStorage.fragmentManager = getSupportFragmentManager();
        onSplash();
    }

    @Override
    public void onSplash() {
        FragmentTransaction transaction = getFragmentTnx();
        transaction.add(mainScreenId, new FragmentSplash(), FragmentSplash.class.getName());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onSplashToMainScreen(Fragment oldFragment) {
        String tag = FragmentMain.class.getName();
        FragmentMain fragment = (FragmentMain)getFragmentMng().findFragmentByTag(tag);

        FragmentTransaction transaction = getFragmentTnx();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);

        if(null == fragment){
            fragment = new FragmentMain();
            transaction.add(mainScreenId, fragment, tag);
        }else{
            transaction.show(fragment);
        }
        transaction.remove(oldFragment);
        transaction.commitAllowingStateLoss();
    }

}
