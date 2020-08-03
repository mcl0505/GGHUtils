package com.ggh.gghlibrary.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * @Author Create by mcl
 * @Date 2020/3/18
 * @ClassName StringUtil
 * @描述
 */
public class StringUtil {
    private static DecimalFormat sDecimalFormat;
    private static DecimalFormat sDecimalFormat2;
    // private static Pattern sPattern;
    private static Pattern sIntPattern;
    private static StringUtil instance;

    public static StringUtil getInstance() {
        if (instance == null){
            synchronized (StringUtil.class){
                if (instance == null){
                    instance = new StringUtil();
                }
            }
        }
        return instance;
    }

    static {
        sDecimalFormat = new DecimalFormat("#.#");
        sDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        sDecimalFormat2 = new DecimalFormat("#.##");
        sDecimalFormat2.setRoundingMode(RoundingMode.DOWN);
        //sPattern = Pattern.compile("[\u4e00-\u9fa5]");
        sIntPattern = Pattern.compile("^[-\\+]?[\\d]*$");
    }

    /**
     * 剪切字符串
     * @param str
     * @param first
     * @param up
     * @return
     */
    public String subString(String str,int first,int up){
        return str.substring(first,str.length()-up);
    }

    /**
     * 科学计数法转为正常String
     * @param str
     * @return
     */
    public String scienceToString(String str){
        BigDecimal bd = new BigDecimal(str);
       return bd.toPlainString();
    }

    /**
     * 判断字符串是否为空或为null
     *
     * @param str
     * @return
     */
    public boolean getNull(String str) {
        return str == null || TextUtils.equals(str, "");
    }

    /**
     * 判断一个字符串是否是数字
     */
    public static boolean isInt(String str) {
        return sIntPattern.matcher(str).matches();
    }

}
