package com.oic.bookreminder.common.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by khacpham on 5/24/15.
 */
public class TimeUtils implements JsonDeserializer<Date> {
    public static String to2Number(int time) {
        if (time < 0 || time > 99) {
            time = 0;
        }
        if (time < 10) {
            return "0" + time;
        }
        return String.valueOf(time);
    }


    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String s = json.getAsJsonPrimitive().getAsString();
        long l = Long.parseLong(s.substring(6, s.length() - 2));
        Date d = new Date(l);
        return d;
    }
}
