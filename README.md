### 常用工具类封装

#### SPUtils---常用SharedPreferences封装工具类 
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

#### GlideUtils---配合Glide图片加载框架使用的封装工具类
[**传送门**](https://github.com/GiitSmile/ToolUtils/blob/master/app/src/main/java/com/muyang/toolutils/common/GlideUtils.java)

**注意事项**  GlideUtils加载图片的封装，圆形、圆角，模糊等处理操作用到了[glide-transformations](https://github.com/wasabeef/glide-transformations)，需要额外添加依赖：compile 'jp.wasabeef:glide-transformations:2.0.1'(注意更换版本)

**简单使用方法**：
- 常规加载图片：loadImage(Context context, ImageView imageView,String imgUrl, boolean isFade)
- 加载缩略图：loadThumbnailImage(Context context, ImageView imageView, String imgUrl)
- 加载图片并设置为指定大小：loadOverrideImage(Context context, ImageView imageView,String imgUrl, int withSize, int heightSize)
- 加载图片并对其进行模糊处理：loadBlurImage(Context context, ImageView imageView, String imgUrl)
- 加载圆图：loadCircleImage(Context context, ImageView imageView, String imgUrl)
- 加载模糊的圆角的图片：loadBlurCircleImage(Context context, ImageView imageView, String imgUrl)
- ....

#### permission---Android6.0运行时权限获取封装工具类

[**传送门**](https://github.com/GiitSmile/ToolUtils/tree/master/app/src/main/java/com/muyang/toolutils/common/permission)

**注意事项** 此封装类根据郭霖在2016/12/27日作出的视频直播内容制作，[**视频地址**](http://edu.csdn.net/course/detail/3539)

**简单使用方法**：

继承BaseActivity传入所需权限，并且记得还要在AndroidManifest文件中申请所请求的权限

requestRunTimePermission(String[] permissions, IPermission listener)

回调接口提供onGranted()和onDenied(List<String> deniedPermission)两个回调方法供使用
