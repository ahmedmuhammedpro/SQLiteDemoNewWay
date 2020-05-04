package com.example.sqlitedemonewway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater inflater;
    private List<Word> words;

    WordListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (words != null) {
            Word currentWord = words.get(position);
            holder.wordTextView.setText(currentWord.getWord());
        } else {
            holder.wordTextView.setText("no word");
        }
    }

    @Override
    public int getItemCount() {
        return words != null? words.size() : 0;
    }

    public void setWords(List<Word> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordTextView;

        private WordViewHolder(View view) {
            super(view);
            wordTextView = view.findViewById(R.id.textView);
        }
    }
}
