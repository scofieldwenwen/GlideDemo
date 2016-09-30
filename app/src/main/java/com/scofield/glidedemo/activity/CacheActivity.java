package com.scofield.glidedemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.scofield.glidedemo.R;

import static com.scofield.glidedemo.R.id.iv_1;
import static com.scofield.glidedemo.R.id.iv_2;
import static com.scofield.glidedemo.R.id.iv_3;
import static com.scofield.glidedemo.R.id.iv_4;

/**
 diskCacheStrategy() 方法来说不同的枚举参数的意义：
 DiskCacheStrategy.NONE 什么都不缓存，就像刚讨论的那样
 DiskCacheStrategy.SOURCE 仅仅只缓存原来的全分辨率的图像。在我们上面的例子中，将会只有一个 1000x1000 像素的图片
 DiskCacheStrategy.RESULT 仅仅缓存最终的图像，即，降低分辨率后的（或者是转换后的）
 DiskCacheStrategy.ALL 缓存所有版本的图像（默认行为）

 按照递增priority(优先级)的列表：
 Priority.LOW
 Priority.NORMAL
 Priority.HIGH
 Priority.IMMEDIATE

 */
public class CacheActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);

        ImageView imageView1 = (ImageView) findViewById(iv_1);
        ImageView imageView2 = (ImageView) findViewById(iv_2);
        ImageView imageView3 = (ImageView) findViewById(iv_3);
        ImageView imageView4 = (ImageView) findViewById(iv_4);


        Glide.with(this).load("http://image.tianjimedia.com/uploadImages/2012/235/KCBO4IX2D947.jpg")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.LOW)
                .placeholder(R.mipmap.default_image)
                .centerCrop()
                .animate(R.anim.slide_in_left)
                .into(imageView1);

        Glide.with(this).load("http://img.wallpapersking.com/d7/2012-8/20120807141932.jpg")
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.mipmap.default_image)
                .centerCrop()
                .priority(Priority.NORMAL)
                .into(imageView2);

        Glide.with(this).load("http://bizhi.zhuoku.com/2012/08/18/Mountain_Lion/Mountain_lion18.jpg")
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.default_image)
                .centerCrop()
                .priority(Priority.HIGH)
                .thumbnail( 0.1f )  //加载缩略图
                .into(imageView3);

        Glide.with(this).load("http://www.pp3.cn/uploads/20120713j/496.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.default_image)
                .centerCrop()
                .priority(Priority.IMMEDIATE)
                .into(imageView4);
    }
}
