package com.ggh.gghlibrary.http;

import android.content.Context;

import com.ggh.gghlibrary.utils.GsonUtil;
import com.ggh.gghlibrary.utils.LogUtil;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author Create by mcl
 * @Date 2020/3/11
 * @ClassName HttpUtils
 * @描述
 */
public class HttpUtils {
    public static int SUCCESS_CODE = 200;
    private static String TAG = "HttpUtils";

    private HttpUtils() {
    }

    private static EasyObserver sendRequest(Context context, boolean isShowDialog, HttpCallBack callBack) {
        EasyObserver<JsonBean> observer = setEasyObserver(context, isShowDialog, callBack);
        return observer;
    }

    private static EasyObserver sendRequest(Context context, HttpCallBack callBack) {
        EasyObserver<JsonBean> observer = setEasyObserver(context, true, callBack);
        return observer;
    }

    private static EasyObserver setEasyObserver(Context context, boolean isShowDialog, final HttpCallBack callBack) {
        return new EasyObserver<JsonBean>(context, isShowDialog) {
            @Override
            public void onSuccess(int code, String msg, JsonBean result, String page) {
                LogUtil.e("第二道处理=" + result.getMeta().toString());
                String json = GsonUtil.formGson().toJson(result.getData());
                if (msg.isEmpty()) {
                    msg = " ";
                }
                callBack.onSuccess(code, msg, json, page);
            }

            @Override
            public void onFailure(Throwable e, int code, String errorMsg) {
                if (errorMsg == null || errorMsg.isEmpty()) {
                    errorMsg = "错误信息为空";
                }
                callBack.onError(code, errorMsg);
            }
        };
    }

    //上传图片
    private static MultipartBody.Part upFile(File file) {
        RequestBody fileRQ = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("picture", file.getName(), fileRQ);
        return part;
    }

    /**
     * 注册用户
     *
     * @param map
     * @param callBack
     */
    public static void registerUserInfo(Context context, Map<String, String> map, HttpCallBack callBack) {
        RetrofitUtils.getApiUrl().registerUserInfo(map)
                .subscribe(sendRequest(context, callBack));
    }


}
