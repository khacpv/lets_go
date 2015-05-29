package com.oic.bookreminder.app.addbook;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.oic.bookreminder.R;
import com.oic.bookreminder.app.AppFragment;
import com.oic.bookreminder.app.addbook.screens.FragmentAddPageFinal;
import com.oic.bookreminder.app.addbook.screens.FragmentAddTime;
import com.oic.bookreminder.app.addbook.screens.FragmentAddTitle;
import com.oic.bookreminder.common.BaseActivity;
import com.oic.bookreminder.models.implement.DbInteraction;
import com.oic.bookreminder.models.tables.Book;
import com.oic.bookreminder.vendor.views.viewpager.ParallaxViewPagerIndicator;
import com.oic.bookreminder.vendor.views.viewpager.transform.RotateDownTransformer;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khacpham on 5/21/15.
 */
public class FragmentAddBookV2 extends AppFragment implements ViewPager.OnPageChangeListener {
    RelativeLayout layoutAddBook;
    ImageView fragmentAddBookButtonEdit;

    ParallaxViewPagerIndicator viewPagerAddBook;
    CirclePageIndicator indicatorAddBook;

    AdapterAddBook adapterAddBook;
    ArrayList<AppFragment> fragments = new ArrayList<>();

    AppFragment fragmentAddTitle;
    AppFragment fragmentAddTime;
    AppFragment fragmentAddPageFinal;

    ArrayList<ViewPager.OnPageChangeListener> pageChangeListeners = new ArrayList<>();

    public FloatingActionMenu floatMenu;
    public FloatingActionMenu.Builder actionMenuBuilder;
    public SubActionButton button1;
    public SubActionButton button2;
    public SubActionButton button3;
    public SubActionButton button4;

    public Book book;

    @Override
    protected View inflateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addbook_v2,container,false);
    }

    @Override
    protected void findControls(View viewParent) {
        layoutAddBook = (RelativeLayout)viewParent.findViewById(R.id.layoutAddBook);
        viewPagerAddBook = (ParallaxViewPagerIndicator)viewParent.findViewById(R.id.frgAddBook);
        indicatorAddBook = (CirclePageIndicator)viewParent.findViewById(R.id.indicatorAddBook);
        fragmentAddBookButtonEdit = (ImageView)viewParent.findViewById(R.id.fragmentAddBookButtonEdit);
    }

    @Override
    protected void setEventsToControls(View viewParent) {

    }

    @Override
    protected void initializeDefaultData() {
        Book book = null;
        List<Book> books = DbInteraction.getInstance(getActivity()).getBooks();
        if(!books.isEmpty()) {
            book = books.get(books.size() - 1);
        }
        else{
            book = new Book();
        }
        this.book = book;

//        Bitmap bg = MakeBlurImage.createBlurImage(getActivity(),R.drawable.app_background_blur);

        fragmentAddTitle = new FragmentAddTitle();
        fragmentAddTime = new FragmentAddTime();
        fragmentAddPageFinal = new FragmentAddPageFinal();

        fragmentAddTitle.setmFragmentParent(this);
        fragmentAddTime.setmFragmentParent(this);
        fragmentAddPageFinal.setmFragmentParent(this);

        pageChangeListeners.add((ViewPager.OnPageChangeListener) fragmentAddTitle);
        pageChangeListeners.add((ViewPager.OnPageChangeListener) fragmentAddTime);
        pageChangeListeners.add((ViewPager.OnPageChangeListener) fragmentAddPageFinal);

        fragments.add(fragmentAddTitle);
        fragments.add(fragmentAddTime);
        fragments.add(fragmentAddPageFinal);

        viewPagerAddBook.setPageTransformer(true, new RotateDownTransformer());

        adapterAddBook = new AdapterAddBook(((BaseActivity)getActivity()).getFragmentMng(), fragments);

        viewPagerAddBook
            .setOverlapPercentage(0.25f)
            .setAdapter(adapterAddBook);

        indicatorAddBook.setOnPageChangeListener(viewPagerAddBook.getPageChangeListener());
        indicatorAddBook.setViewPager(viewPagerAddBook);

        viewPagerAddBook.addOnPageChangeListener(this);

        viewPagerAddBook.setBackground(BitmapFactory.decodeResource(getResources(), R.drawable.app_background_blur));

        actionMenuBuilder = initCicularMenu();
        setDefaultMenu();
    }

    public void setDefaultMenu(){
        this.fragmentAddBookButtonEdit = this.getButtonEdit();
        floatMenu = actionMenuBuilder.attachTo(fragmentAddBookButtonEdit).build();
    }

    public FloatingActionMenu.Builder initCicularMenu(){
        Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);

        SubActionButton.Builder itemBuilder = null;
        itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView itemIcon1 = new ImageView(getActivity());
        itemIcon1.setImageDrawable(drawable);
        button1 = itemBuilder.setContentView(itemIcon1).build();
        itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView itemIcon2 = new ImageView(getActivity());
        itemIcon2.setImageDrawable(drawable);
        button2 = itemBuilder.setContentView(itemIcon2).build();
        itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView itemIcon3 = new ImageView(getActivity());
        itemIcon3.setImageDrawable(drawable);
        button3 = itemBuilder.setContentView(itemIcon3).build();
        itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView itemIcon4 = new ImageView(getActivity());
        itemIcon4.setImageDrawable(drawable);
        button4 = itemBuilder.setContentView(itemIcon4).build();

        actionMenuBuilder = new FloatingActionMenu.Builder(getActivity())
            .addSubActionView(button1)
            .addSubActionView(button2)
            .addSubActionView(button3)
            .addSubActionView(button4);
        return actionMenuBuilder;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            indicatorAddBook.setAlpha(1 - positionOffset);
        }
        for(ViewPager.OnPageChangeListener listener: pageChangeListeners){
            listener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public ImageView getButtonEdit(){
        return fragmentAddBookButtonEdit;
    }

    public ViewPager getViewPager(){
        return viewPagerAddBook;
    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case FragmentAddTitle.PAGE_ID:
                indicatorAddBook.setVisibility(View.VISIBLE);
                break;
            case FragmentAddTime.PAGE_ID:
            case FragmentAddPageFinal.PAGE_ID:
                indicatorAddBook.setVisibility(View.INVISIBLE);
                break;
        }
        for(ViewPager.OnPageChangeListener listener: pageChangeListeners){
            listener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        for(ViewPager.OnPageChangeListener listener: pageChangeListeners){
            listener.onPageScrollStateChanged(state);
        }
    }

}
