package collegestudents.laundro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    Spinner Fabric, Stains;
    String Str_Fabric, Str_Stains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stain_solver);


        Fabric = (Spinner) findViewById(R.id.Fabric);
        Str_Fabric= Fabric.getSelectedItem().toString();

        Stains = (Spinner) findViewById(R.id.Stain);
        Str_Stains = Stains.getSelectedItem().toString();

        Button StainSubmit = (Button) findViewById(R.id.StainSubmit);




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
}