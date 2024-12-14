package com.example.segmentedcontrolexperiment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textView;
    private ImageButton imageLogo;
    private Button buttonChange;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        // Find views by their ID
        textView = rootView.findViewById(R.id.textView);
        imageLogo = rootView.findViewById(R.id.imageLogo);
        buttonChange = rootView.findViewById(R.id.buttonChange);

        // Set an OnClickListener for the button to change text and hide the image
        if (textView != null && imageLogo != null && buttonChange != null) {
            buttonChange.setOnClickListener(v -> {
                // Change the text of the TextView and center it
                textView.setText("HELLO EVERYONE ITS ME NATIVE PROGRAMMING");
                textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

                // Hide the image
                imageLogo.setVisibility(View.GONE);
            });
        }

        return rootView;
    }
}
