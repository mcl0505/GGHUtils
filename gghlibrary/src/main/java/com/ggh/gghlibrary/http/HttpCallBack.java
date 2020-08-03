package com.ggh.gghlibrary.http;

/**
 * @Author Create by mcl
 * @Date 2020/3/11
 * @ClassName HttpCallBack
 * @描述
 */
public interface HttpCallBack {
    /**
     * 请求成功回调
     *
     * @param code
     * @param msg
     * @param json
     */
    void onSuccess(int code, String msg, String json, String page);

    /**
     * 请求失败回调
     *
     * @param code
     * @param msg
     */
    void onError(int code, String msg);
}
