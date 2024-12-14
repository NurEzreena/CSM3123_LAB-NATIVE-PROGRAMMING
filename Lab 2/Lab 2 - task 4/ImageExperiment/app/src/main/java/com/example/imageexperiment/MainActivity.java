package com.example.imageexperiment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private boolean isBackgroundOne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Corrected ID reference for RelativeLayout
        layout = findViewById(R.id.relativeLayout);

        Button switchBackgroundButton = findViewById(R.id.switchBackgroundButton);
        switchBackgroundButton.setOnClickListener(v -> {
            if (isBackgroundOne) {
                layout.setBackgroundResource(R.drawable.background2); // Second background image
            } else {
                layout.setBackgroundResource(R.drawable.background1); // First background image
            }
            isBackgroundOne = !isBackgroundOne; // Toggle background state
        });
    }
}
