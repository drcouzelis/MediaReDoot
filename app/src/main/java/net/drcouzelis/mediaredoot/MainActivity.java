package net.drcouzelis.mediaredoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMediaScan(android.view.View view) {
        // Start the media scanner service

        // Extra text data to send to the Intent, informing it which volumes to scan
        Bundle bundle = new Bundle();
        bundle.putString("volume", "external");

        // Reference to the Android MediaScannerService
        ComponentName componentName = new ComponentName("com.android.providers.media", "com.android.providers.media.MediaScannerService");

        // Our intent to start the service
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtras(bundle);

        // Start scanning!
        startService(intent);

        // Notify the user
        Toast.makeText(this, "Media scanner started", Toast.LENGTH_SHORT).show();
    }
}
