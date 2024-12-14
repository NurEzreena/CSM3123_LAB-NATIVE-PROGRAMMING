package com.example.smsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText phoneNumberEditText = findViewById(R.id.phone_number);
        EditText messageEditText = findViewById(R.id.message_text);
        Button sendButton = findViewById(R.id.send_button);

        sendButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                // Use ACTION_SENDTO intent to send SMS
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + phoneNumber)); // Set the SMS URI
                smsIntent.putExtra("sms_body", message); // Set the SMS message body
                try {
                    startActivity(smsIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Failed to send SMS", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter a phone number and message", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
