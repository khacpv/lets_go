package com.oic.bookreminder.network.response;

import com.google.gson.annotations.SerializedName;
import org.apache.http.HttpException;
import rx.Observable;

/**
 * Created by khacpham on 6/23/15.
 */
public class OicEnvelope {
    @SerializedName("code")
    private int httpCode;

    public Observable filterWebServiceErrors() {
        // detect 'code' from backend return
        if (httpCode == 200) {
            return Observable.just(this);
        } else {
            return Observable.error(
                new HttpException("There was a problem fetching data:"+httpCode));
        }
    }
}
