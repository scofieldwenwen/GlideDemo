package com.scofield.glidedemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class LoadImageActivity extends AppCompatActivity {
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    ImageView mMipmapIv;
    ImageView mFileIv;
    ImageView mUriIv;
    ImageView mUrlIv;
    ImageView mHolderIv;
    ImageView mErrorIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        mMipmapIv = (ImageView) findViewById(R.id.iv_mipmap);
        mFileIv = (ImageView) findViewById(R.id.iv_file);
        mUriIv = (ImageView) findViewById(R.id.imageView4);
        mUrlIv = (ImageView) findViewById(R.id.imageView5);
        mHolderIv = (ImageView) findViewById(R.id.imageView6);
        mErrorIv = (ImageView) findViewById(R.id.imageView7);
    }

    public void onLoadMipmapClick(View view) {
        Glide.with(this).load(R.mipmap.ic_launcher).into(mMipmapIv);
    }

    public void onLoadFileClick(View view) {
        File file = new File(Environment.getExternalStorageDirectory() + "/", "123.png");
        Glide.with(this).load(file).into(mFileIv);
    }

    public void onLoadUriClick(View view) {
        Uri uri = resourceIdToUri(this, R.mipmap.ic_launcher);
        Glide.with(this).load(uri).into(mUriIv);
    }

    public void onLoadUrlClick(View view) {
        String url = "http://img0.imgtn.bdimg.com/it/u=3242287019,1587066299&fm=21&gp=0.jpg";
        Glide.with(this).load(url).into(mUrlIv);
    }

    public void onLoadHoderClick(View view) {
        String url = "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=af9259bf03082838770ddb148898a964/6159252dd42a2834bc76c4ab5fb5c9ea14cebfba.jpg";
        Glide.with(this).load(url).placeholder(R.mipmap.default_image).centerCrop().into(mHolderIv);
    }

    public void onLoadErrorClick(View view) {
        String url = "https://";
        Glide.with(this).load(url).placeholder(R.mipmap.default_image).centerCrop().error(R.mipmap.icon_error).into(mErrorIv);
    }


    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
