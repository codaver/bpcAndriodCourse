package com.studying.mroshchin.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.studying.mroshchin.exercise1.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchPreviewActivity(View view) {
        EditText messageEdit = findViewById(R.id.messageText);
        Intent intent = new Intent(this, PreviewActivity.class);
        String message = messageEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
