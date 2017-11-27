package collegestudents.laundro;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
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
        DatePicker reminderDP = (DatePicker)findViewById(R.id.reminderDP);
        TimePicker reminderTP = (TimePicker)findViewById(R.id.reminderTP);

        // Create the calendar that will hold the date and time for the reminder
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, reminderDP.getYear());
        cal.set(Calendar.MONTH, reminderDP.getMonth());
        cal.set(Calendar.DAY_OF_MONTH, reminderDP.getDayOfMonth());
        cal.set(Calendar.HOUR_OF_DAY, reminderTP.getHour());
        cal.set(Calendar.MINUTE, reminderTP.getMinute());
        cal.set(Calendar.SECOND, 0);
        setNotification(cal.getTimeInMillis());

        // Get the reminder text
        String message = ((EditText)findViewById(R.id.reminderET)).getText().toString();

        // Show a toast to the user
        Toast.makeText(this, "Reminder set for " + message + "!", Toast.LENGTH_LONG).show();
    }

    public void setNotification(long dateAndTime)
    {
        Intent nIntent = new Intent(this, NReceiver.class);

        // Put the notification object in the intent so that the receiver can get it
        nIntent.putExtra("notification", makeNotification());
        PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, nIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Add the change in time to the current clock to get when it should happen
        long futureTime = dateAndTime;

        // Set the alarm
        AlarmManager aManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        aManager.set(AlarmManager.RTC_WAKEUP, futureTime, pIntent);
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
