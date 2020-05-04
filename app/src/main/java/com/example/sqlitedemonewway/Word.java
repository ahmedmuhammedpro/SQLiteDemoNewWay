package com.example.sqlitedemonewway;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "word")
    private String word;

    public Word(@NonNull String word) {
        this.word = word;
    }

    @NonNull
    public String getWord() {
        return word;
    }
}
