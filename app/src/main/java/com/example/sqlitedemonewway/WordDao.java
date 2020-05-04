package com.example.sqlitedemonewway;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("delete from word_table")
    void deleteAll();

    @Query("select * from word_table")
    LiveData<List<Word>> getAllWords();
}
