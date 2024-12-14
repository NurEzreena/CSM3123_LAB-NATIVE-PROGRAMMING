package com.example.layoutexploration;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        // Define options directly in code
        String[] options = {"FSKM", "FPSM", "FTKK", "FSSM"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Reference to the Spinner and set the adapter
        Spinner optionsSpinner = findViewById(R.id.optionsSpinner);
        optionsSpinner.setAdapter(adapter);

        // Apply window insets to handle system bars and make the content display correctly
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the insets for system bars (status bar, navigation bar, etc.)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Set the padding to avoid overlapping with system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets.consumeSystemWindowInsets(); // Indicate that system bar insets have been consumed
        });
    }
}
