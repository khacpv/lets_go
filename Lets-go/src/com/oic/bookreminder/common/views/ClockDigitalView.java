package com.oic.bookreminder.common.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.oic.bookreminder.R;
import com.oic.bookreminder.common.utils.TimeUtils;
import com.zenkun.datetimepicker.time.RadialPickerLayout;
import com.zenkun.datetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by khacpham on 5/24/15.
 */
public class ClockDigitalView extends LinearLayout implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    private FragmentManager fragmentManager;
    private View parentView;

    private int hourOfDay = 0;
    private int minutes = 0;
    private int seconds = 0;

    TextSwitcher hour, minute, second;
    private TimePickerDialog.OnTimeSetListener listener;
    private OnClockDigitalClickListener clockDigitalClickListener;

    public ClockDigitalView(Context context) {
        super(context);
        inflateLayout();
    }

    public ClockDigitalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateLayout();
    }

    public ClockDigitalView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateLayout();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hour:
            case R.id.minute:
            case R.id.second:
                Calendar calendar = Calendar.getInstance();
                showSelectTimeDialog(fragmentManager,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true,ClockDigitalView.class.getName(),null);
                break;
        }
    }

    public void showSelectTimeDialog(FragmentManager fragmentManager, int hourOfDay, int minute, boolean is24HourMode, String tag, TimePickerDialog.OnTimeSetListener listener) {
        setFragmentManager(fragmentManager);
        this.listener = listener;
        TimePickerDialog time = TimePickerDialog.newInstance(this, hourOfDay, minute, is24HourMode);
        time.show(fragmentManager, tag);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        this.hourOfDay = hourOfDay;
        this.minutes = minute;

        this.hour.setText(TimeUtils.to2Number(hourOfDay));
        this.minute.setText(TimeUtils.to2Number(minute));
        this.second.setText(TimeUtils.to2Number(Calendar.getInstance().get(Calendar.SECOND)));
        if (null != listener) {
            listener.onTimeSet(view, hourOfDay, minute);
        }

    }


    private void inflateLayout() {
        parentView = LayoutInflater.from(getContext()).inflate(R.layout.view_clock_digital, null);
        addView(parentView);

        hour = (TextSwitcher) parentView.findViewById(R.id.hour);
        minute = (TextSwitcher) parentView.findViewById(R.id.minute);
        second = (TextSwitcher) parentView.findViewById(R.id.second);

        ViewSwitcher.ViewFactory factory = new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create new textView and set the properties like clolr, size etc
                TextView myText = new TextView(getContext());
                myText.setGravity(Gravity.CENTER);
                myText.setTextSize(20);
                myText.setSingleLine(true);
                myText.setTextColor(Color.WHITE);
                myText.setText("00");
                return myText;
            }
        };
        hour.setFactory(factory);
        minute.setFactory(factory);
        second.setFactory(factory);

        // Declare the in and out animations and initialize them
        Animation in = AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right);

        // set the animation type of textSwitcher
        hour.setInAnimation(in);
        hour.setOutAnimation(out);

        minute.setInAnimation(in);
        minute.setOutAnimation(out);

        second.setInAnimation(in);
        second.setOutAnimation(out);

        hour.setOnClickListener(this);
        minute.setOnClickListener(this);
        second.setOnClickListener(this);

        hour.setText("00");
        minute.setText("00");
        second.setText("00");
    }

    public void setOnClockDigitalClickListener(OnClockDigitalClickListener listener) {
        this.clockDigitalClickListener = listener;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public interface OnClockDigitalClickListener {
        void onTimeChange(TextView viewHour, TextView viewMinutes, TextView viewSecond, int hour, int minute, int second);
    }
}
