package collegestudents.laundro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by don on 10/25/17.
 */

public class Stain_Solution extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stain_solver);


        Spinner SpiFabric = findViewById(R.id.Fabric);
        final String Fabric = SpiFabric.getSelectedItem().toString();

        Spinner SpiStain = findViewById(R.id.Stain);
        final String Stain = SpiStain.getSelectedItem().toString();

        final Button Solution = (Button) findViewById(R.id.StainSubmit);
        Solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.stain_solution);
            }
        });



        // 1. get passed intent
        Intent intent = getIntent();

        // 2. get message value from intent
        String message = intent.getStringExtra("message");

        // 3. show message on textView
        ((TextView)findViewById(R.id.Solution)).setText(message);

        // 4. get bundle from intent
        Bundle bundle = intent.getExtras();

        // 5. get status value from bundle
        String status = bundle.getString("status");

        // 6. show status on Toast
        Toast toast = Toast.makeText(this, status, Toast.LENGTH_LONG);
        toast.show();
    }
}
