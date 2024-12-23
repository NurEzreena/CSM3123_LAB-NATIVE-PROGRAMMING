package com.example.roomdatabasedemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Annotate the class as a Room Database and declare its entities and version
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    // Singleton instance of the database
    private static UserDatabase instance;

    // Abstract method for accessing DAO
    public abstract UserDao userDao();

    // Synchronized method to get the instance of the database
    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            // Create the database if it does not exist
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration() // Handle migrations destructively
                    .build();
        }
        return instance;
    }
}
