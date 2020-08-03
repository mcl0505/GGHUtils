package com.ggh.gghlibrary.http;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiUrl {

    // 注册
    @POST("user/addUser")
    @FormUrlEncoded
    Observable<JsonBean> registerUserInfo(@FieldMap Map<String, String> map);

}
