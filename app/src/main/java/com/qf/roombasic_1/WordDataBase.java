package com.qf.roombasic_1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * entities 里面可以用逗号分割多个class
 * version 每次entity类发生改变的时候，version也必须修改+1
 */
@Database(entities = {com.qf.roombasic_1.Word.class}, version = 1, exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {

    public abstract com.qf.roombasic_1.WordDao getWordDao();

}
