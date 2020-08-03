package com.ggh.gghlibrary.http;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit封装
 */
public class RetrofitUtils {

    private static final String TAG = "RetrofitUtils";
    public static String hostUrl = "AppConfig.HOST_URL";
    private static int DEFAULT_TIME = 10000;
    private static ApiUrl mApiUrl;

    private RetrofitUtils() {
    }

    /**
     * 单例模式
     */
    public static ApiUrl getApiUrl() {
        mApiUrl = new RetrofitUtils().getRetrofit();
        return mApiUrl;
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private static Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(hostUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public static OkHttpClient initHeaderOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new HeaderInterceptor())//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
    }

    public ApiUrl getRetrofit() {
        // 初始化Retrofit
        mApiUrl = initRetrofit(initHeaderOkHttp()).create(ApiUrl.class);
        return mApiUrl;
    }
}

