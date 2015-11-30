package com.lee.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Lee on 2015/11/30.
 */
public class MyApp extends Application {
    public static ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        //ShareUtils.init(this);

        //初始化ImageLoader和参数
        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        imageLoader.init(configuration);

    }
}
