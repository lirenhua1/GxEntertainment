package com.lee.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lee.app.MyApp;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by Lee on 2015/11/30.
 */
public class XutilsUtil {
    /**
     *HttpGet请求下载JSON数据
     * @param url
     * @param requestCallBack
     * @return
     */
    public static String requestString(String url, final RequestCallBack requestCallBack){
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                requestCallBack.onSuccess(responseInfo);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                requestCallBack.onFailure(error,msg);
            }
        });
        return  url;
    }

    /**
     * 图片请求
     * @param imgUrl
     * @param iv
     * @param resId
     * @param errorResId
     */
    public static void requestImage(String imgUrl,ImageView iv, int resId, int errorResId){
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                .showImageOnLoading(resId) //正在加载显示的图片
                .showImageOnFail(errorResId) //加载失败显示的图片
                .cacheInMemory(true) //开启内存缓存
                .cacheOnDisk(true)   //开启磁盘缓存
                        // 实际加载的时候，先去内存中找，找不到再去磁盘中找，最后再去网上下载
                .bitmapConfig(Bitmap.Config.ARGB_8888);
        DisplayImageOptions options = builder.build();
        MyApp.imageLoader.displayImage(imgUrl, iv, options);
    }


}
