package com.example.pratikum_pertemuan6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        com.example.pratikum_pertemuan6.NotificationHelper notificationHelper = new com.example.pratikum_pertemuan6.NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannel_1Notification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}