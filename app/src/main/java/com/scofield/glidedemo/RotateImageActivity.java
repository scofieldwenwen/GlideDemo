package com.scofield.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.scofield.glidedemo.R.id.iv_1;
import static com.scofield.glidedemo.R.id.iv_2;

public class RotateImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_image);
        ImageView imageView1 = (ImageView) findViewById(iv_1);
        ImageView imageView2 = (ImageView) findViewById(iv_2);

        String url = "http://img2.imgtn.bdimg.com/it/u=706650600,2601477740&fm=11&gp=0.jpg";
        Glide.with(this).load(url).into(imageView1);

        Glide.with(this).load(url).transform(new RotateTransformation(this, 90)).into(imageView2);

    }
}
