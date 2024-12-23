package com.example.roomdatabasedemo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
    }

    // Insert User
    public void insert(User user) {
        new Thread(() -> userDao.insert(user)).start();
    }

    // Update User
    public void update(User user) {
        new Thread(() -> userDao.update(user)).start();
    }

    // Delete User
    public void delete(User user) {
        new Thread(() -> userDao.delete(user)).start();
    }

    // Get all users
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    // Search users
    public LiveData<List<User>> searchUsers(String query) {
        return userDao.searchUsers(query);
    }

    // Insert Task
    public void insertTask(Task task) {
        new Thread(() -> userDao.insertTask(task)).start();
    }

    // Get tasks for a specific user
    public LiveData<List<UserWithTask>> getUserWithTasks(int userId) {
        return userDao.getUserWithTask(userId);
    }
}
