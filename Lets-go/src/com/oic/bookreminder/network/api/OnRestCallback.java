package com.oic.bookreminder.network.api;

/**
 * Created by khacpham on 6/23/15.
 */
public interface OnRestCallback {
    void onNetSuccess(int requestCode, int responseCode, String data);
    void onNetError(int requestCode, int responseCode, String error);
}
