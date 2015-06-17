package com.oic.bookreminder.app.mainscreen.comment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.InjectView;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.models.tables.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 6/17/15.
 */
public class FragmentComment extends AppFragment{

    @InjectView(R.id.listComment)
    ListView listComment;

    AdapterComment adapterComment;
    List<Comment> comments;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment,container,false);
        return view;
    }

    @Override
    protected void initializeDefaultData() {
        comments = new ArrayList<>();
        adapterComment = new AdapterComment(getActivity(),comments);
        listComment.setAdapter(adapterComment);
    }
}
