package com.example.roomdatabasedemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private EditText editTextName, editTextAge, editTextSearch;
    private Button buttonAddUser;
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextName = findViewById(R.id.edit_text_name);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonAddUser = findViewById(R.id.button_add);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Set up Adapter
        adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        // Initialize ViewModel
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, adapter::setUsers);

        // Add User button functionality
        buttonAddUser.setOnClickListener(v -> addUser());

        // Handle RecyclerView item click listeners for user and task display
        adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onUpdateClick(User user) {
                // Handle user update functionality if needed
            }

            @Override
            public void onDeleteClick(User user) {
                userViewModel.delete(user);
                Toast.makeText(MainActivity.this, "User deleted successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to add a new user
    private void addUser() {
        String name = editTextName.getText().toString().trim();
        String ageText = editTextAge.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(ageText)) {
            Toast.makeText(this, "Please enter both name and age!", Toast.LENGTH_SHORT).show();
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Age must be a valid number!", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(name, age);
        userViewModel.insert(user);

        // Clear input fields after adding user
        editTextName.setText("");
        editTextAge.setText("");

        Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show();
    }
}
