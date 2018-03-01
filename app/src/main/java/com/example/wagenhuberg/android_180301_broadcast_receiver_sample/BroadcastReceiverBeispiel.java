package com.example.wagenhuberg.android_180301_broadcast_receiver_sample;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by wagenhuberg on 01.03.2018.
 */

public class BroadcastReceiverBeispiel extends BroadcastReceiver {

    public static final String TAG = BroadcastReceiverBeispiel.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            Log.d(TAG, "Flugmodus geaendert");
            String message = DateFormat.getDateTimeInstance().format(new Date());

            //Notification Builder für Einblenden Android System-Benachrichtigungen
            Notification.Builder builder = new Notification.Builder(context);
            builder.setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("Flugmodus").setContentText(message).setWhen(System.currentTimeMillis());
            Notification notification = builder.build();
            NotificationManager m = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            m.notify(4711, notification);
        }
    }
}
