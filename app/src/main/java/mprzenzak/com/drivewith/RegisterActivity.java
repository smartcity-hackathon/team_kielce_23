package mprzenzak.com.drivewith;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button startWindowBtn = (Button) findViewById(R.id.startWindowBtn);
        startWindowBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), StartWindow.class);
                //dupa kuby
                startActivity(startIntent);
            }
        });
    }
}
