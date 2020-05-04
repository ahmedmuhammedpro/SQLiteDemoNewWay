package com.example.sqlitedemonewway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String NEW_WORD_ACTIVITY_REPLY = "reply";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        editText = findViewById(R.id.edit_word);

        Button save = findViewById(R.id.button_save);
        save.setOnClickListener(v -> {
            Intent intent = new Intent();
            String word = editText.getText().toString();
            if (!TextUtils.isEmpty(word)) {
                intent.putExtra(NEW_WORD_ACTIVITY_REPLY, word);
                setResult(RESULT_OK, intent);
            } else {
                setResult(RESULT_CANCELED, intent);
            }

            finish();
        });
    }
}
