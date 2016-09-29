package com.scofield.glidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoadImageClick(View view) {
        startActivity(new Intent(this,LoadImageActivity.class));
    }
    public void onLoadGifClick(View view) {
        startActivity(new Intent(this,LoadGifActivity.class));
    }

    public void onCacheClick(View view) {
        startActivity(new Intent(this, CacheActivity.class));
    }
    public void onTargetClick(View view) {
        startActivity(new Intent(this, TargetActivity.class));
    }
    public void onRotateClick(View view) {
        startActivity(new Intent(this, RotateImageActivity.class));
    }
}
