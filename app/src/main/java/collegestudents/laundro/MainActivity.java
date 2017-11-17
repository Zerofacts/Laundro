package collegestudents.laundro;

import android.content.DialogInterface;
import android.content.Intent;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stain_solver);

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

    public void ToStainSolution(View view) {


        Button StainSubmit = (Button) findViewById(R.id.StainSubmit);

    }
}
