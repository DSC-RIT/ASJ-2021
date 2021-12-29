package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val notes: ArrayList<String>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.note, parent, false)
        return NotesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val notesContent = notes[position]
        holder.notesTextView.text = notesContent

        holder.doneButton.setOnClickListener {
            notes.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = notes.size

    class NotesViewHolder(val layout: View): RecyclerView.ViewHolder(layout) {
        val notesTextView = layout.findViewById<TextView>(R.id.notes_text)
        val doneButton = layout.findViewById<Button>(R.id.done_button)
    }
}