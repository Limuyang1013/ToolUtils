package com.muyang.toolutils.common;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limuyang on 2016/12/21.
 * 常用SharedPreferences封装工具类
 */

public class SPUtils {
    /**
     * 保存在手机里的文件名
     */
    private static final String FILE_NAME="DATA";

    /**
     * 向SharedPreferences存储int型数据
     * @param context 上下文参数
     * @param key   键
     * @param value 值
     */
    public static void putIntValue(Context context,String key,int value){
       SharedPreferences.Editor sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        sp.putInt(key, value).apply();
    }

    /**
     * 从SharedPreferences中返回int型数据
     * @param context 上下文参数
     * @param key   键
     * @param defValue 读取失败返回的默认值
     */
    public static int getIntValue(Context context,String key,int defValue){
        SharedPreferences sp=getSharedPreferences(context);
        return sp.getInt(key,defValue);
    }

    /**
     * 向SharedPreferences存储boolean型数据
     * @param context 上下文参数
     * @param key   键
     * @param value 值
     */
    public static void putBooleanValue(Context context,String key,boolean value){
        SharedPreferences.Editor sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        sp.putBoolean(key,value).apply();
    }

    /**
     * 从SharedPreferences中返回boolean型数据
     * @param context   上下文参数
     * @param key   键
     * @param defValue  读取失败返回的默认值
     * @return
     */
    public static boolean getBooleanValue(Context context,String key,boolean defValue){
        SharedPreferences sp=getSharedPreferences(context);
        return sp.getBoolean(key,defValue);
    }

    /**
     * 向SharedPreferences存储string型数据
     * @param context 上下文参数
     * @param key   键
     * @param value 值
     */
    public static void putStringValue(Context context,String key,String value){
        SharedPreferences.Editor sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        sp.putString(key, value).apply();
    }

    /**
     * 从SharedPreferences中返回String型数据
     * @param context   上下文参数
     * @param key   键
     * @param defValue  读取失败返回的默认值
     * @return
     */
    public static String getStringValue(Context context, String key, String defValue){
        SharedPreferences sp=getSharedPreferences(context);
        return sp.getString(key, defValue);
    }

    /**
     * 向SharedPreferences存储float型数据
     * @param context 上下文参数
     * @param key 键
     * @param value 值
     */
    public static void putFloatValue(Context context,String key,float value){
        SharedPreferences.Editor sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        sp.putFloat(key,value).apply();
    }

    /**
     * 从SharedPreferences中返回float型数据
     * @param context   上下文參數
     * @param key   键
     * @param defValue  读取失败返回的默认值
     * @return
     */
    public static float getFloatValue(Context context,String key,float defValue){
        SharedPreferences sp=getSharedPreferences(context);
        return sp.getFloat(key, defValue);
    }

    /**
     * 向SharedPreferences存储long型数据
     * @param context   上下文参数
     * @param key   键
     * @param value 值
     */
    public static void putLongValue(Context context,String key,long value){
        SharedPreferences.Editor sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        sp.putLong(key,value).apply();
    }

    /**
     * 从SharedPreferences中返回long型数据
     * @param context 上下文参数
     * @param key   键
     * @param defValue  值
     * @return
     */
    public static long getLongValue(Context context,String key,long defValue){
        SharedPreferences sp=getSharedPreferences(context);
        return sp.getLong(key, defValue);
    }


    /**
     * 存储List<String>
     *
     * @param context 上下文参数
     * @param key     List<String>对应的key
     * @param strList 对应需要存储的List<String>
     */
    public static void putStrListValue(Context context, String key,
                                       List<String> strList) {
        if (null == strList) {
            return;
        }
        // 保存之前先清理已经存在的数据，保证数据的唯一性
        removeStrList(context, key);
        int size = strList.size();
        putIntValue(context, key + "size", size);
        for (int i = 0; i < size; i++) {
            putStringValue(context, key + i, strList.get(i));
        }
    }

    /**
     * 取出List<String>
     *
     * @param context
     * @param key     List<String> 对应的key
     * @return List<String>
     */
    public static List<String> getStrListValue(Context context, String key) {
        List<String> strList = new ArrayList<String>();
        int size = getIntValue(context, key + "size", 0);
        //Log.d("sp", "" + size);
        for (int i = 0; i < size; i++) {
            strList.add(getStringValue(context, key + i, null));
        }
        return strList;
    }


    /**
         * 清空List<String>所有数据
     *
     * @param context 上下文参数
     * @param key     List<String>对应的key
     */
    public static void removeStrList(Context context, String key) {
        int size = getIntValue(context, key+"size", 0);
        if (0 == size) {
            return;
        }
        remove(context, key+"size");
        for (int i = 0; i < size; i++) {
            remove(context, key + i);
        }
    }

    /**
     * 清空对应key数据
     *
     * @param context 上下文参数
     * @param key 键
     */
    public static void remove(Context context, String key) {
        SharedPreferences.Editor sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                .edit();
        sp.remove(key).apply();
    }

    /**
     * @param context
     * @param key     List<String>对应的key
     * @param str     List<String>中的元素String
     * @Description TODO 清空List<String>单条数据
     */
    public static void removeStrListItem(Context context, String key, String str) {
        int size = getIntValue(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        List<String> strList = getStrListValue(context, key);
        // 待删除的List<String>数据暂存
        List<String> removeList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (str.equals(strList.get(i))) {
                if (i >= 0 && i < size) {
                    removeList.add(strList.get(i));
                    remove(context, key + i);
                    putIntValue(context, key + "size", size - 1);
                }
            }
        }
        strList.removeAll(removeList);
        // 删除元素重新建立索引写入数据
        putStrListValue(context, key, strList);
    }

    //返回SharedPreferences实例
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }


    /**
     * 清空所有数据
     *
     * @param context 上下文参数
     */
    public static void clear(Context context) {
        SharedPreferences.Editor sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
                .edit();
        sp.clear().apply();
    }
}
