package com.example.roomdatabasedemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    // Insert User
    public void insert(User user) {
        repository.insert(user);
    }

    // Update User
    public void update(User user) {
        repository.update(user);
    }

    // Delete User
    public void delete(User user) {
        repository.delete(user);
    }

    // Get all users
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    // Search users
    public LiveData<List<User>> searchUsers(String query) {
        return repository.searchUsers(query);
    }

    // Insert Task
    public void insertTask(Task task) {
        repository.insertTask(task);
    }

    // Get tasks for a specific user
    public LiveData<List<UserWithTask>> getUserWithTasks(int userId) {
        return repository.getUserWithTasks(userId);
    }
}
