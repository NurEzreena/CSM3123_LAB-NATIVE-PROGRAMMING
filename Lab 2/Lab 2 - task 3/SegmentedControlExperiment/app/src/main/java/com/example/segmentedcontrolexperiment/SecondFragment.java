package com.example.segmentedcontrolexperiment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private EditText inputField;
    private Button submitButton;
    private TextView displayText;
    private ImageView headerImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        // Initialize views
        inputField = rootView.findViewById(R.id.inputField);
        submitButton = rootView.findViewById(R.id.submitButton);
        displayText = rootView.findViewById(R.id.displayText);
        headerImage = rootView.findViewById(R.id.headerImage);

        // Set an OnClickListener for the submit button
        submitButton.setOnClickListener(v -> {
            String userInput = inputField.getText().toString();
            if (!userInput.isEmpty()) {
                // Display the entered text in displayText and make it visible
                displayText.setText(" " + userInput);
                displayText.setVisibility(View.VISIBLE);
            } else {
                // Prompt the user to enter something if the field is empty
                displayText.setText("Please enter something!");
                displayText.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }
}
