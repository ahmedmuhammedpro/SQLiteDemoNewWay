package com.example.sqlitedemonewway;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
abstract class WordRoomDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    private static WordRoomDatabase INSTANCE;

    static ExecutorService databaseExecutors = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WordRoomDatabase getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(application, WordRoomDatabase.class,
                            "words_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    abstract WordDao wordDao();
}
