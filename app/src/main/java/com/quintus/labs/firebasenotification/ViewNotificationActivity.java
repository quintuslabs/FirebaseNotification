package com.quintus.labs.firebasenotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewNotificationActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notification);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // extract the extra-data in the Notification
            String _title = extras.getString("title");
            String msg = extras.getString("message");
            TextView title = findViewById(R.id.avn_title);
            TextView message = findViewById(R.id.avn_message);
            title.setText(_title);
            message.setText(msg);

        }
    }
}
