#### SPUtils 常用SharedPreferences封装工具类 
[**传送门**](https://github.com/GiitSmile/ToolUtils/blob/master/app/src/main/java/com/muyang/toolutils/common/SPUtils.java)

**支持存储类型**:
- int
- float
- boolean
- string
- List<String>

**简单使用方法**：
- 存储简单数据类型：putxxxValue(Context context,String key,xxx value)
- 取出简单数据类型：getxxxValue(Context context,String key,xxx defValue)
- 存储List<String>：putStrListValue(Context context, String key,List<String> strList)
- 取出List<String>：getStrListValue(Context context, String key)
- 清空List<String>所有数据：removeStrList(Context context, String key)
- 清空对应key数据：remove(Context context, String key)
- 清空所有数据：clear(Context context)
