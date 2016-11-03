package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by yanshu on 2016/11/3.
 */

public class MyService extends Service {

    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate called.");
        NotificationManager mNotificationManager = (NotificationManager) MyService.this.getSystemService(Context.NOTIFICATION_SERVICE);
        /*Notification notification = new Notification(R.mipmap.ic_launcher,
                "有通知到来", System.currentTimeMillis());*/
        Intent notificationIntent = new Intent();//this,MainActivity.class);
        notificationIntent.setAction("android.intent.action.SINGLE_INSTANCE_MAIN2");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        /*notification.setLatestEventInfo(this, "这是通知的标题", "这是通知的内容",
                pendingIntent);*/
        Notification.Builder builder = new Notification.Builder(MyService.this.getApplicationContext()).setContentTitle("这是通知的标题")
                .setContentText("这是通知的内容").setSmallIcon(R.mipmap.ic_launcher).setTicker("tickerText").setContentIntent(pendingIntent);
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_ONGOING_EVENT;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        mNotificationManager.notify(101, notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand called.");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind called.");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind called.");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy called.");
    }


}
