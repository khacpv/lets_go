package com.oic.bookreminder.app.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;

import java.util.ArrayList;

/**
 * Created by khacpham on 5/17/15.
 */
public class FragmentLibrary extends AppFragment implements AdapterView.OnItemClickListener {
    GridView lvLibrary;
    AdapterLibrary adapterLibrary;
    ArrayList<String> lstBooks;

    OnBookSelectListener listener;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        lvLibrary = (GridView) viewParent.findViewById(R.id.lvLibrary);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        lstBooks = new ArrayList<>();
        String[] sample = getResources().getStringArray(R.array.reviews);
        int i =0;
        for(String str: sample){
            lstBooks.add("The World is flat"+ i++);
        }

        adapterLibrary = new AdapterLibrary(getActivity(),lstBooks);
        lvLibrary.setAdapter(adapterLibrary);

        lvLibrary.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(null != listener){
            listener.onBookSelect(view,lstBooks.get(position));
        }
    }

    public void setOnBookSelectListener(OnBookSelectListener listener){
        this.listener = listener;
    }

    public interface OnBookSelectListener{
        void onBookSelect(View v, Object book);
    }
}
