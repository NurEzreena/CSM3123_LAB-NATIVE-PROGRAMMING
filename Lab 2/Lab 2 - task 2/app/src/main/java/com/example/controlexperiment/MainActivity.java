package com.example.controlexperiment;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner);
        Switch switchControl = findViewById(R.id.switchControl);
        ImageButton imageButton = findViewById(R.id.imageButton);

        // Set up spinner data
        String[] options = {"Software Engineering", "Mobile Computing", "Informatic Maritime"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set Switch listener
        switchControl.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "Enabled" : "Disabled";
            Toast.makeText(MainActivity.this, "Switch is " + status, Toast.LENGTH_SHORT).show();
        });

        // Set ImageButton listener
        imageButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Camera Button Clicked", Toast.LENGTH_SHORT).show()
        );

        // Button click listener with data validation
        button.setOnClickListener(v -> {
            String input = editText.getText().toString();

            // Data validation with AlertDialog
            if (input.isEmpty()) {
                new AlertDialog.Builder(this)
                        .setTitle("Input Required")
                        .setMessage("Please enter some text before proceeding.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
                return;
            }

            boolean isChecked = checkBox.isChecked();
            int selectedId = radioGroup.getCheckedRadioButtonId();
            String selectedRadioText = selectedId != -1 ?
                    ((RadioButton) findViewById(selectedId)).getText().toString() : "None";
            String selectedSpinner = spinner.getSelectedItem().toString();

            // Show a Toast message with the collected input
            Toast.makeText(this, "Input: " + input + "\nChecked: " + isChecked +
                    "\nSelected Radio: " + selectedRadioText +
                    "\nSelected Spinner: " + selectedSpinner, Toast.LENGTH_LONG).show();
        });
    }
}
