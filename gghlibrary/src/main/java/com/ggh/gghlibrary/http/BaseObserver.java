package com.ggh.gghlibrary.http;

import com.ggh.gghlibrary.utils.GsonUtil;
import com.ggh.gghlibrary.utils.LogUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 数据返回统一处理
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<JsonBean<T>> {
    private static final String TAG = "BaseObserver";
    private static String PAGE = "page";
    private static String noData = "";
    @Override
    public void onNext(JsonBean<T> jsonBean) {
        //在这边对 基础数据 进行统一处理  举个例子：
        if(jsonBean.getMeta().getCode() == HttpUtils.SUCCESS_CODE){
            String j = GsonUtil.formGson().toJson(jsonBean);
            LogUtil.e("第一次返回的数="+j);
            if (j.contains(PAGE)){
                String page = GsonUtil.formGson().toJson(jsonBean.getPage());
                if (page.isEmpty()){
                    onSuccess(jsonBean.getMeta().getCode(),jsonBean.getMeta().getMsg(),jsonBean, noData);
                }else {
                    onSuccess(jsonBean.getMeta().getCode(),jsonBean.getMeta().getMsg(),jsonBean,page);
                }
            }else {
                onSuccess(jsonBean.getMeta().getCode(),jsonBean.getMeta().getMsg(),jsonBean, noData);
            }

        }else{
            onFailure(null,jsonBean.getMeta().getCode(),jsonBean.getMeta().getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {//服务器错误信息处理
        LogUtil.e(e.getMessage());
        LogUtil.e(e.toString());
        onFailure(e,0,"服务器返回数据解析失败");
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    public abstract void onSuccess(int code, String msg, JsonBean result, String page);

    public abstract void onFailure(Throwable e,int code,String errorMsg);

}
