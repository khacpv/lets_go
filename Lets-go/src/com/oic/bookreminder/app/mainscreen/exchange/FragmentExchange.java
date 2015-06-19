package com.oic.bookreminder.app.mainscreen.exchange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.models.tables.Exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentExchange extends AppFragment{

    @InjectView(R.id.listExchange)
    ListView listExchange;

    AdapterExchange adapterExchange;
    List<Exchange> exchanges;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exchange_fragment,container,false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        exchanges = new ArrayList<>();
        adapterExchange = new AdapterExchange(getActivity(), exchanges);
        listExchange.setAdapter(adapterExchange);
    }
}
