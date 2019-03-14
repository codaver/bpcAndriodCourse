package com.studying.mroshchin.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button previewButton = findViewById(R.id.previewButton);
        previewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchPreviewActivity();
            }
        });
    }

    public void launchPreviewActivity() {
        EditText messageEdit = findViewById(R.id.messageText);
        String message = messageEdit.getText().toString();
        PreviewActivity.start(this, message);
    }
}
