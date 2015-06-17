package com.oic.bookreminder.app.mainscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentMain extends AppFragment{
    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}
