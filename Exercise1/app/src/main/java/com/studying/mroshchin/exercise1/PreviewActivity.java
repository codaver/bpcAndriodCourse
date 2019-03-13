package com.studying.mroshchin.exercise1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.studying.mroshchin.exercise1.MainActivity.EXTRA_MESSAGE;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        Intent intent = getIntent();
        final String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.messageView);
        textView.setText(message);
    }

    public void launchEmailActivity(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Test Recipient"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test subject");

        Intent intent = getIntent();
        final String message = intent.getStringExtra(EXTRA_MESSAGE);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(PreviewActivity.this, "Opening mailing app", Toast.LENGTH_SHORT).show();
            startActivity(emailIntent);
        } else {
            Toast.makeText(PreviewActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
