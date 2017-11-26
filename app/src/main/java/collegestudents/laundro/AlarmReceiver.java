// https://stackoverflow.com/questions/28017943/android-how-to-set-a-notification-to-a-specific-date-in-the-future#comment44423150_28017943
// ^ used as guide for this reciever
package collegestudents.laundro;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends Service
{
    private String rText = "Message not set";

    @Override
    public IBinder onBind(Intent i)
    {
        rText = i.getExtras().getString("REMINDER_TEXT");
        return null;
    }

    @Override
    public void onCreate()
    {
        Intent i = new Intent();
        PendingIntent myPI = PendingIntent.getActivity(this, 123, i, 0);
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Time to do laundry!")
                .setContentText(rText);
        notifBuilder.setContentIntent(myPI);
        //notifBuilder.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManager nManager = (NotificationManager)this.
                getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(123, notifBuilder.build());
    }
}
