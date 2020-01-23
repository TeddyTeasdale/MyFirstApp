package uk.ac.tees.t7091808.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button send  = (Button) this.findViewById(R.id.button);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                String recipient = ((TextView) findViewById(R.id.RecipientTextView)).getText().toString();
                String subject = ((TextView) findViewById(R.id.subjectTextView)).getText().toString();
                String body = ((TextView) findViewById(R.id.bodyTextView)).getText().toString();
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {recipient}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();

                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }



        });

    }
}
