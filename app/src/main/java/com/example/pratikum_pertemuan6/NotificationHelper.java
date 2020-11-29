package com.example.pratikum_pertemuan6;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    private static final String channel1id = "channel1ID";
    private static final String channel1name = "Channel 1";
    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels(){
        NotificationChannel channel_1 = new NotificationChannel(channel1id, channel1name,
                NotificationManager.IMPORTANCE_DEFAULT);
        channel_1.enableVibration(true);
        channel_1.setLightColor(R.color.colorPrimary);

        channel_1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel_1);
    }

    public NotificationManager getManager() {
        if (mManager == null){
            mManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder
    getChannel_1Notification() {
        Intent intent = new Intent(this,AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        return new NotificationCompat.Builder(getApplicationContext(), channel1id)
                .setSmallIcon(R.drawable.ic_baseline_alarm_on_24)
                .setContentTitle("Pesan")
                .setAutoCancel(true)
                .setContentText("Alarm - 1818034");
    }
}

   
