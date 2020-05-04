package com.kibekin.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private RecyclerView recyclerViewNotes;
        static final ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);

        if (notes.isEmpty()) {
            notes.add(new Note("Парикмахерская", "Сделать прическу", "Понедельник", 2));
            notes.add(new Note("Баскетбол", "Игра со школьной командой", "Вторник", 3));
            notes.add(new Note("Магазин", "Купить новые джинсы", "Понедельник", 3));
            notes.add(new Note("Магазин", "Купить новые шорты", "Понедельник", 2));
            notes.add(new Note("Стоматолог", "Вылечить зубы", "Понедельник", 2));
            notes.add(new Note("Парикмахер", "Сделать прическу к выпускному", "Вторник", 1));
            notes.add(new Note("Баскетбол", "Игра с дворовой командой", "Среда", 1));
        }

        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this ));
        recyclerViewNotes.setAdapter(adapter);
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}
