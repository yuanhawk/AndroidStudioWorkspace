package com.example.mynotepad.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotepad.R;
import com.example.mynotepad.model.Note;
import com.example.mynotepad.utils.NoteUtils;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder>{

    private ArrayList<Note> notes;

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_layout, parent, false);
        return new NotesHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder holder, int position) {
        Note note = getNotes(position);
        if(note != null){
            holder.noteText.setText(note.getNoteText());
            holder.noteDate.setText(NoteUtils.dateFromLong(note.getNoteDate()));
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private Note getNotes(int position) {
        return notes.get(position);
    }

    class NotesHolder extends RecyclerView.ViewHolder {

        TextView noteText, noteDate;
        public NotesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
