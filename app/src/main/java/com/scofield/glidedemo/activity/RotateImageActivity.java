package com.scofield.glidedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.scofield.glidedemo.transform.CircleTransform;
import com.scofield.glidedemo.R;
import com.scofield.glidedemo.transform.RotateTransformation;
import com.scofield.glidedemo.transform.RoundTransform;

import static com.scofield.glidedemo.R.id.iv_1;
import static com.scofield.glidedemo.R.id.iv_2;
import static com.scofield.glidedemo.R.id.iv_3;
import static com.scofield.glidedemo.R.id.iv_4;

public class RotateImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_image);
        ImageView imageView1 = (ImageView) findViewById(iv_1);
        ImageView imageView2 = (ImageView) findViewById(iv_2);
         ImageView imageView3 = (ImageView) findViewById(iv_3);
         ImageView imageView4 = (ImageView) findViewById(iv_4);

        String url = "http://192.168.31.185:8080/deplay/images/uavator/hmg91474615529741.jpg";
        Glide.with(this).load(url).into(imageView1);

        Glide.with(this).load(url).transform(new RotateTransformation(this, 90)).into(imageView2);
        Glide.with(this).load(url).transform(new RoundTransform(this)).into(imageView3);
        Glide.with(this).load(url).dontAnimate().transform(new CircleTransform(this)).into(imageView4);

    }

}
