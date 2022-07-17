package com.qf.roombasic_1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    public void insertWord(Word...words);

    @Update
    public int updateWords(Word...words);

    @Delete
    public int deleteWords(Word...words);

    @Query("DELETE FROM WORD")
    public void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    public List<Word> getAllWords();
}
