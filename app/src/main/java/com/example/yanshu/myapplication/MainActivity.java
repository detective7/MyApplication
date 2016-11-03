package com.example.yanshu.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
            }
        });//localNotification();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, this.toString()+"   "+this.getTaskId(), Toast.LENGTH_SHORT).show();

        Log.e("launch instance",this.toString());
        Log.e("launch task id",this.getTaskId()+"");
    }

    public void localNotification() {
        Log.i("abc", "localNotification");
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) MainActivity.this.getSystemService(ns);
        int icon = R.mipmap.ic_launcher;
        CharSequence tickerText = "小U防丢器断开了";
        long when = System.currentTimeMillis();

        CharSequence contentTitle = "小U防丢器";
        CharSequence contentText = "为了App能正常使用，请允许后台运行（Android）自在找App需要后台运行才能正常工作，以保证定位准确性和及时的防丢提醒， 请按照以下设置检查手机："+

                "1.检查手机系统中的省电设置，将自在找APP加入白名单或受保护程序，防止自在找被系统关闭。"+

                "2.小米手机请在“设置”——“其他高级设置”——“电量和性能”——“神隐模式”——“应用配置”——中找到自在找，并点击进入，设置为“无限制”，并在后台定位中选择“允许定位”"+

                "3.魅族手机请在“设置”——“电量管理”——“省电优化”——“待机耗电管理”中找到自在找，并打开开关，允许自在找在锁屏后运行。"+

                "4.检查手机中360安全卫士、软件管家等安全软件中的应用自启动管理，将自在找加入白名单，防止被此类软件关闭。"+

                "5.完成上述操作后，请重启一下手机，让设置生效！"+

                "6.请不要手动杀掉自在找app。";
        Context context = MainActivity.this.getApplicationContext();
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        // notification.setLatestEventInfo(context, contentTitle, contentText,
        // contentIntent);
        Notification.Builder builder = new Notification.Builder(context).setContentTitle(contentTitle)
                .setContentText(contentText).setSmallIcon(icon).setTicker(tickerText).setContentIntent(contentIntent);
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_ONGOING_EVENT;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        mNotificationManager.notify(11322, notification);
    }
}
