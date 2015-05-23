package com.oic.bookreminder.app.addbook.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddTitle extends AppFragment{
    TextView title;
    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addtitle,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        title = (TextView)viewParent.findViewById(R.id.title);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        YoYo.with(Techniques.Tada).duration(1500).delay(500).interpolate(new BounceInterpolator(getActivity(),null)).playOn(title);
    }
}
