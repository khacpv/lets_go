package com.oic.bookreminder.app.mainscreen.suggest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.common.views.CustomActionbar;
import com.oic.bookreminder.models.tables.Suggest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentSuggest extends AppFragment implements CustomActionbar.OnSearchable{

    @InjectView(R.id.listSuggest)
    ListView listSuggest;

    AdapterSuggest adapterSuggest;
    List<Suggest> suggests;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suggest_fragment,container,false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        suggests = new ArrayList<>();
        adapterSuggest = new AdapterSuggest(getActivity(), suggests);
        listSuggest.setAdapter(adapterSuggest);
    }

    @Override
    public void onSearch(String text) {

    }
}
