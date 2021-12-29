package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditText = findViewById<EditText>(R.id.notes_pt)
        val insertButton = findViewById<Button>(R.id.insert_button)

        val notes = ArrayList<String>()
        val recyclerView = findViewById<RecyclerView>(R.id.notes_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        insertButton.setOnClickListener {
            val inputNotes = inputEditText.text.toString()
            notes.add(inputNotes)
            recyclerView.adapter = NotesAdapter(notes)
        }
    }
}