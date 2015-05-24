package com.oic.bookreminder.common.utils;

/**
 * Created by khacpham on 5/24/15.
 */
public class TimeUtils {
    public static String to2Number(int time){
        if(time<0 || time > 99){
            time = 0;
        }
        if(time<10){
            return "0"+time;
        }
        return String.valueOf(time);
    }
}
