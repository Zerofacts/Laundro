package collegestudents.laundro;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class NReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "******", Toast.LENGTH_LONG).show();    // Testing purposes

        NotificationManager nManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Get the stored notification
        Notification n = intent.getParcelableExtra("notification");
        nManager.notify(1, n);
    }
}
