package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment2, container, false)

        // Get the data from arguments
        val message = arguments?.getString("message")

        // Display the message in the TextView
        val textView: TextView = view.findViewById(R.id.display_message)
        textView.text = message

        // Button action
        val button: Button = view.findViewById(R.id.button_action)
        button.setOnClickListener {
            // Perform any action here when the button is clicked
            textView.text = "Action performed!"
        }

        return view
    }
}
