package com.oic.bookreminder.app.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/29/15.
 */
public class FragmentReview extends AppFragment{
    ListView lvReview;
    AdapterReview adapterReview;
    ArrayList<String> lstReview;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        lvReview = (ListView)viewParent.findViewById(R.id.lvReview);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        lstReview = new ArrayList<>();
        String[] sample = getResources().getStringArray(R.array.reviews);
        for(String str: sample){
            lstReview.add(str);
        }

        adapterReview = new AdapterReview(getActivity(),lstReview);
        lvReview.setAdapter(adapterReview);
    }
}
