package com.oic.bookreminder.common.views;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;
import com.oic.bookreminder.R;

/**
 * Created by khacpham on 6/17/15.
 */
public class CustomActionbar extends LinearLayout{

    RelativeLayout layout;

    @InjectView(R.id.imvMenu)
    ImageView imvMenu;

    @InjectView(R.id.tvTitle)
    TextView tvTitle;

    @InjectView(R.id.edtSearch)
    EditText edtSearch;

    @InjectView(R.id.imvSearch)
    ImageView imvSearch;

    OnActionbarListener listener;

    private Intent intentTextChanged;

    private TextView.OnEditorActionListener imeOptionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (null != listener) {
                    listener.onSearch(edtSearch.getText().toString());
                }
                return true;
            }
            return false;
        }
    };

    private TextWatcher textChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            intentTextChanged.putExtra(SearchManager.QUERY,edtSearch.getText().toString());
            getContext().sendBroadcast(intentTextChanged);
        }
    };

    public CustomActionbar(Context context) {
        super(context);
        init();
    }

    public CustomActionbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomActionbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        layout = (RelativeLayout)LayoutInflater.from(getContext()).inflate(R.layout.common_actionbar,null);
        addView(layout);
        ButterKnife.inject(this);

        initDefaultData();
    }

    private void initDefaultData(){
        edtSearch.setOnEditorActionListener(imeOptionListener);
        edtSearch.addTextChangedListener(textChangeListener);

        intentTextChanged = new Intent(Intent.ACTION_SEARCH);

        showSearch(false);
    }

    public void showSearch(boolean isShow){
        if(isShow){
            edtSearch.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.FadeOut).duration(200).interpolate(new OvershootInterpolator()).playOn(imvSearch);
            YoYo.with(Techniques.FadeIn).duration(200).interpolate(new OvershootInterpolator()).withListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    edtSearch.requestFocus();
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            }).playOn(edtSearch);
        }else{
            edtSearch.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.FadeIn).duration(200).interpolate(new OvershootInterpolator()).playOn(imvSearch);
            YoYo.with(Techniques.FadeOut).duration(200).interpolate(new OvershootInterpolator()).withListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    edtSearch.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            }).playOn(edtSearch);
        }
        intentTextChanged.putExtra(SearchManager.QUERY,edtSearch.getText().toString());
        getContext().sendBroadcast(intentTextChanged);
    }

    public boolean isSearching(){
        return edtSearch.getVisibility() == View.VISIBLE;
    }

    @OnClick(R.id.imvSearch)
    public void onSearchClick(View v){
        showSearch(true);
    }

    @OnClick(R.id.imvMenu)
    public void onMenuClick(View v){
        if(null != listener){
            listener.onMenuClick(v);
        }
    }

    public void setTitle(String text){
        tvTitle.setText(text);
    }

    public void setOnActionbarListener(OnActionbarListener listener){
        this.listener = listener;
    }

    public interface OnActionbarListener extends OnSearchable{
        void onMenuClick(View v);
    }

    public interface OnSearchable{
        /**
         * Fire on user click search button keyboard
         * */
        void onSearch(String text);
    }
}
