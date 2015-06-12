package com.oic.bookreminder.app.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentSplash extends AppFragment{

    @InjectView(R.id.logo_imv)
    ImageView logo;

    @InjectView(R.id.logo_text_1)
    TextView text1;

    @InjectView(R.id.logo_text_2)
    TextView text2;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash,container, false);
        return view;
    }

    @Override
    protected void findControls(View viewParent) {
        super.findControls(viewParent);
    }

    @Override
    protected void initializeDefaultData() {
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);

        super.mHandler.postDelayed(logoAnimation, 500);
    }

    private void goToNextScreen(){
        mFlowScreen.onSplashToProfile(this);
    }

    private Runnable logoAnimation = new Runnable() {
        @Override
        public void run() {
            text1.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.SlideInLeft).duration(500).interpolate(new LinearInterpolator()).playOn(text1);
            YoYo.with(Techniques.SlideInRight).duration(500).interpolate(new LinearInterpolator()).playOn(text2);

            goToNextScreen();
        }
    };
}
