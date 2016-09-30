package com.scofield.glidedemo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.scofield.glidedemo.R;

public class TargetActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    private NotificationTarget notificationTarget;

    //请求需要在 activity 生命周期之外去做时,用 application 的 context
    SimpleTarget<Bitmap> target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            imageView.setImageBitmap(resource);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        String url = "http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/09/ChMkJlbKzxeIf3IRAAMtxFku2FUAALJRgEiX4wAAy3c387.jpg";
        Glide.with(this).load(url).asBitmap().into(target);

        RemoteViews rv = new RemoteViews(this.getPackageName(), R.layout.remoteview_notification);
        rv.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.default_image);
        rv.setTextViewText(R.id.remoteview_notification_headline, "Headline");
        rv.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setContent(rv)
                .setPriority( NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, notification);

        notificationTarget = new NotificationTarget(
                this,
                rv,
                R.id.remoteview_notification_icon,
                notification,
                0);

        Glide
                .with( this.getApplicationContext() ) // safer!
                .load( url )
                .asBitmap()
                .into( notificationTarget );
    }


}
