package com.studying.mroshchin.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.studying.mroshchin.exercise1.extra.MESSAGE";

    public static void start(Activity activity, String message) {
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        Intent intent = getIntent();
        final String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.messageView);
        textView.setText(message);
        Button emailButton = findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchEmailActivity(v);
            }
        });
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
            startActivity(emailIntent);
        } else {
            Toast.makeText(PreviewActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
        }
    }
}
