package com.sudipcseseu.notificationwithfcm.helper;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.sudipcseseu.notificationwithfcm.activity.AuthActivity;
import com.sudipcseseu.notificationwithfcm.activity.MainActivity;
import com.sudipcseseu.notificationwithfcm.R;

public class NotificationHelper {

    public static void displayNotification(Context context, String title, String body) {

        // Intent to go to the MainActivity after notification click
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                100,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        // Building the notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, AuthActivity.CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(context);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
