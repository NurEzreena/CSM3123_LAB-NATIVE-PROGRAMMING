package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView greetingTextView;
    private EditText nameEditText, ageEditText, cityEditText;
    private Button saveButton, loadButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Views
        greetingTextView = findViewById(R.id.tv_greeting);
        nameEditText = findViewById(R.id.et_name);
        ageEditText = findViewById(R.id.et_age);
        cityEditText = findViewById(R.id.et_city);
        saveButton = findViewById(R.id.btn_save);
        loadButton = findViewById(R.id.btn_load);
        clearButton = findViewById(R.id.btn_clear);

        // Set Button Click Listeners
        saveButton.setOnClickListener(view -> saveData());
        loadButton.setOnClickListener(view -> loadData());
        clearButton.setOnClickListener(view -> clearData());
    }

    private void saveData() {
        String name = nameEditText.getText().toString().trim();
        String age = ageEditText.getText().toString().trim();
        String city = cityEditText.getText().toString().trim();

        // Input Validation
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(city)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save Data
        editor.putString("userName", name);
        editor.putString("userAge", age);
        editor.putString("userCity", city);
        editor.apply();

        greetingTextView.setText("Data saved!");
        Toast.makeText(this, "Data successfully saved!", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("userName", "No name saved");
        String age = sharedPreferences.getString("userAge", "No age saved");
        String city = sharedPreferences.getString("userCity", "No city saved");

        greetingTextView.setText("Welcome, " + name + "! Age: " + age + ", City: " + city);
    }

    private void clearData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Clear All Data
        editor.clear();
        editor.apply();

        greetingTextView.setText("Data cleared!");
        Toast.makeText(this, "All data has been cleared.", Toast.LENGTH_SHORT).show();
    }
}
