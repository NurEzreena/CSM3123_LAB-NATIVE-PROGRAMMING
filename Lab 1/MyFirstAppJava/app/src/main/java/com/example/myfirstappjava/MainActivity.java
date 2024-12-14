package com.example.myfirstappjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Button Clicked!");
                textView.setTextColor(Color.RED);

                Toast.makeText(MainActivity.this, "Button was clicked!", Toast.LENGTH_SHORT).show();

            }

        });

        Button buttonNav = findViewById(R.id.buttonNavigate);
        buttonNav.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("EXTRA_MESSAGE","Hello from MainActivity!");
                startActivity(intent);
            }
        });
    }
}