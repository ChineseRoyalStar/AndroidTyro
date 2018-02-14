package com.example.armada.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                // 生成通知内容
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent,0);

                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setAutoCancel(true) //自动取消通知栏
                        //.setSound() // 设置铃声通知
                        .setVibrate(new long[]{0,1000,1000,1000}) // 设置震动，振动1s，静止1s后再振动1s，设置振动需要权限
                        .setLights(Color.GREEN,1000,1000) // 第一个参数设置LED灯的颜色，第二个参数设置灯亮起的时间，第三个参数设置灯暗去的时间
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)
                        //.setStyle() NotificationCompat.BigTextStyle.bigText  NotificationCompat.BigPicture.bigPicture
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
