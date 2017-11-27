

package collegestudents.laundro;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ReminderActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
    }

    public void setReminder(View v)
    {
        EditText daysET = (EditText)findViewById(R.id.dayET);
        String message = ((EditText)findViewById(R.id.reminderET)).getText().toString();

        // For now, I'm using seconds in order to test the notification
        int daysFromNow = Integer.parseInt(daysET.getText().toString()) * 1000;

        setNotification(daysFromNow);

        Toast.makeText(this, "Reminder set for " +  message + " in " + daysFromNow, Toast.LENGTH_LONG).show();
    }

    public void setNotification(int deltaTime)
    {
        Intent nIntent = new Intent(this, NReceiver.class);

        // Put the notification object in the intent so that the reciever can get it
        nIntent.putExtra("notification", makeNotification());
        PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, nIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Add the change in time to the current clock to get when it should happen
        long futureTime = SystemClock.elapsedRealtime() + deltaTime;

        // Set the alarm
        AlarmManager aManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        aManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureTime, pIntent);
    }

    // Method that makes the notifcation
    private Notification makeNotification()
    {
        String message = ((EditText)findViewById(R.id.reminderET)).getText().toString();
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Time to do laundry!")
                .setSmallIcon(R.drawable.launcher_icon)
                .setContentText(message);
        Notification n = notifBuilder.build();
        return n;
    }


}
