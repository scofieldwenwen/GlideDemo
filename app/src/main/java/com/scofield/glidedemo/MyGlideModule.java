package com.scofield.glidedemo;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * @author scofield@tronsis.com
 * @date 2016/9/28 11:07
 */

public class MyGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //在 Android 中有两个主要的方法对图片进行解码：ARGB8888 和 RGB565。前者为每个像素使用了 4 个字节，后者仅为每个像素使用了 2 个字节。
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);//ARGB8888 的优势是图像质量更高以及能存储一个 alpha 通道。

        //设置RAM最大缓存
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

        //设置磁盘缓存
        int cacheSizeBytes = 104857600; //100M
        //        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSizeBytes));//应用的私有目录
        //        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSizeBytes));//外部存储
        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
        builder.setDiskCache(new DiskLruCacheFactory(downloadDirectoryPath, cacheSizeBytes));//磁盘缓存到指定的目录
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
