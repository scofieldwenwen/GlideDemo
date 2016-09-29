package com.scofield.glidedemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import static com.scofield.glidedemo.R.id.iv_gif4;

public class LoadGifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_gif);
        ImageView imageView1 = (ImageView) findViewById(R.id.iv_gif1);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_gif2);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_gif3);
        ImageView imageView4 = (ImageView) findViewById(iv_gif4);

        Glide.with(this)
                .load("http://img5.imgtn.bdimg.com/it/u=3780748590,994692897&fm=21&gp=0.jpg")
                .placeholder(R.mipmap.default_image)
                .error(R.mipmap.icon_error)
                .into(imageView1);

        Glide.with(this)
                .load("http://upload-images.jianshu.io/upload_images/1379058-ad1cdef7c8da6721.png?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300")
                .asGif()    //判断是否为gif,error() 回调被调用并且错误占位符被显示，即使 gifUrl 是一个完美的图片（但不是一个 Gif）
                .placeholder(R.mipmap.default_image)
                .error(R.mipmap.icon_error)
                .into(imageView2);

        Glide.with(this)
                .load("http://img5.imgtn.bdimg.com/it/u=3780748590,994692897&fm=21&gp=0.jpg")
                .asBitmap()   //获取第一帧,静态图片
                .placeholder(R.mipmap.default_image)
                .error(R.mipmap.icon_error)
                .centerCrop()
                .into(imageView3);

        //本地视频
        String filePath = "/storage/emulated/0/Pictures/123.mp4";
        Glide.with(this)
                .load(Uri.fromFile(new File(filePath)))
                .into( imageView4 );
    }
}
