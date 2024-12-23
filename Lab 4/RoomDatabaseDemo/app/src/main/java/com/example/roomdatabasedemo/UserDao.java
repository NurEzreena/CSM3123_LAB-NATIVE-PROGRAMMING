package com.example.roomdatabasedemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM user_table WHERE name LIKE :searchQuery")
    LiveData<List<User>> searchUsers(String searchQuery);

    // Insert task
    @Insert
    void insertTask(Task task);

    // Get tasks for a specific user
    @Transaction
    @Query("SELECT * FROM user_table WHERE id = :userId")

    LiveData<List<UserWithTask>> getUserWithTask(int userId);
}
