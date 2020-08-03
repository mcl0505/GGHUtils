package com.ggh.gghlibrary.utils;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * @Author Create by mcl
 * @Date 2019/12/25
 * @ClassName GsonUtil
 * @描述
 */
public class GsonUtil {
    private static Gson gson;
    public static Gson formGson(){
        if (gson == null){
            synchronized (GsonUtil.class){
                if (gson == null){
                    gson = new Gson();
                }
            }
        }
        return gson;
    }


    // 将jsonArray字符串转换成List集合
    public static List jsonToList(String json, Class beanClass) {
        if (!StringUtil.getInstance().getNull(json)) {
            //这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
            return com.alibaba.fastjson.JSONObject.parseArray(json, beanClass);
        } else {
            return null;
        }
    }
}
