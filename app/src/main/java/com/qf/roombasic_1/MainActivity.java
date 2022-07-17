package com.qf.roombasic_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordDataBase wordDataBase;

    WordDao wordDao;

    Button buttonInsert;
    Button buttonUpdate;
    Button buttonClear;
    Button buttonDelete;
    Button buttonSelect;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordDataBase = Room.databaseBuilder(this, WordDataBase.class, "word_database")
                .allowMainThreadQueries()// 允许主线程执行
                .build();
        wordDao = wordDataBase.getWordDao();
        textView = findViewById(R.id.textView1);
        updateView();

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonSelect = findViewById(R.id.buttonSelect);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("hello", "你好");
                Word word2 = new Word("up", "上");
                wordDao.insertWord(word1,word2);
                updateView();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("morning", "早");
                word1.setId(16);
                wordDao.updateWords(word1);
                updateView();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWords();
                updateView();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("morning", "早");
                word1.setId(16);
                wordDao.deleteWords(word1);
                updateView();
            }
        });

        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateView();
            }
        });
    }

    public void updateView(){
        List<Word> wordList = wordDao.getAllWords();
        String text = "";

        for (int i = 0; i < wordList.size(); i++) {
            Word word = wordList.get(i);
            text += word.getId() + " : " + word.getEnglishWord() + " = " + word.getChineseWord() + "\n";
        }

        textView.setText(text);
    }
}