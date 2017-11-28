package collegestudents.laundro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/*//////////////////////////////////////////////////////////////////////////////////////////////
    Whoever implements the timer, make sure to use a "chronometer". As prof Kochanov mentioned
    in class, a "countdown" from API 24 will not work because she will be building the app using
    API 23. So make sure to use a "chronometer" and not a "countdown".
*///////////////////////////////////////////////////////////////////////////////////////////////

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    Spinner Fabric, Stains;
    String Str_Fabric, Str_Stains;

    private boolean isFirstOpen;


    // Why was the main screen previously the stain_solver layout?
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stain_solver);

    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = this.getSharedPreferences("first", Context.MODE_PRIVATE);
        isFirstOpen = prefs.getBoolean("firstTime", true);
        // Check to see if the app has been opened before. If it has not been. Make this the first
        // time and show the info activity
        if(isFirstOpen)
        {
            SharedPreferences.Editor spe = prefs.edit();
            spe.putBoolean("firstTime", false);
            spe.commit();

            setContentView(R.layout.activity_info);
        }
        // Otherwise, show the homescreen
        else
        {
            setContentView(R.layout.homescreen);
        }

    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("collegestudents.Stain_Solver");
        intent.putExtra("message", "Hello From MainActivity");
        Bundle extras = new Bundle();
        extras.putString("status", "Data Received!");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void continueToHome(View v)
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }

    public void ToStainSolution(View view) {
        Button StainSubmit = (Button) findViewById(R.id.StainSubmit);

    }

    // Method to go the the reminder screen when clicked
    public void reminder(View v)
    {
        Intent myIntent = new Intent(this, ReminderActivity.class);
        this.startActivity(myIntent);
    }
}
