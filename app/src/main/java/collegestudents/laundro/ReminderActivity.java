// https://stackoverflow.com/questions/28017943/android-how-to-set-a-notification-to-a-specific-date-in-the-future
// ^ used as a guide for this section

package collegestudents.laundro;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        // Get a calendar with default timezone and locale
        Calendar myCalendar = Calendar.getInstance();

        EditText daysET = (EditText)findViewById(R.id.reminderET);
        int daysFromNow = Integer.parseInt(daysET.getText().toString());

        // Add the number of days to the calendar
        myCalendar.add(Calendar.DATE, daysFromNow);

        Intent myIntent = new Intent(this, AlarmReciever.class);
        PendingIntent myPI = PendingIntent.getBroadcast(this, 001, myIntent, 0);
        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, myCalendar.getTimeInMillis(),myPI);


    }

}
