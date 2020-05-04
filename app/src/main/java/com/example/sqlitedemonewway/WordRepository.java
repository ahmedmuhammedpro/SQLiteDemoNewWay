package com.example.sqlitedemonewway;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getInstance(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAllWords();
    }

    void insert(Word word) {
        WordRoomDatabase.databaseExecutors.execute(() -> wordDao.insert(word));
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }
}
