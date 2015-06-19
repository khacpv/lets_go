package com.oic.bookreminder.app.mainscreen.ask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.models.tables.Ask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentAsk extends AppFragment{

    @InjectView(R.id.listAsk)
    ListView listAsk;

    AdapterAsk adapterAsk;
    List<Ask> asks;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ask_fragment,container,false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        asks = new ArrayList<>();
        adapterAsk = new AdapterAsk(getActivity(), asks);
        listAsk.setAdapter(adapterAsk);
    }
}
