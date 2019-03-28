package com.studying.mroshchin.businesscard;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDisclaimer();
        TextView info = findViewById(R.id.personal_info);
        info.setMovementMethod(new ScrollingMovementMethod());
        // Message
        Button messageButton = findViewById(R.id.messageButton);
        messageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchEmailActivity(findViewById(R.id.messageText).toString());
            }
        });
        // Telegram
        ImageView telegram = findViewById(R.id.telegram);
        telegram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://t.me/mikerosh"));
                startActivity(browserIntent);
            }
        });
        // Instagram
        ImageView instagram = findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
					    Uri.parse("https://www.instagram.com/i_m_just_mike/"));
                startActivity(browserIntent);
            }
        });
    }

    private void addDisclaimer() {
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // code for portrait mode
            RelativeLayout layout = findViewById(R.id.layout);
            TextView disclaimer = new TextView(this);
            disclaimer.setText(getString(R.string.disclaimer));
            disclaimer.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.text_size));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, // Width
                    ViewGroup.LayoutParams.WRAP_CONTENT // Height
            );
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            disclaimer.setLayoutParams(params);
            layout.addView(disclaimer);
        } else {
            // code for landscape mode
            ConstraintLayout layout = findViewById(R.id.layout_land);
            TextView disclaimer = new TextView(this);
            disclaimer.setText(getString(R.string.disclaimer));
            disclaimer.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.text_size));
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, // Width
                    ViewGroup.LayoutParams.WRAP_CONTENT // Height
            );
            params.endToEnd = 0;
            params.startToStart = 0;
            params.bottomToBottom = 0;
            params.bottomMargin = 10;
            disclaimer.setLayoutParams(params);
            layout.addView(disclaimer);
        }
    }

    public void launchEmailActivity(String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dontactualywrite@here.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
        }
    }
}
