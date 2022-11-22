package com.harunbekcan.mynotesapp.ui.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.mynotesapp.data.entity.Note
import com.harunbekcan.mynotesapp.databinding.ItemNoteLayoutBinding

class MyNotesAdapter(var notesAdapterList : List<Note>, private val itemClick: (Note) -> Unit, private val deleteButtonClick : (Note) -> Unit):
    RecyclerView.Adapter<MyNotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val binding: ItemNoteLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = ItemNoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val notes = notesAdapterList[position]
        holder.binding.apply {
            noteTitleTextView.text = notes.title
            noteDescriptionTextView.text = notes.description

            noteCardView.setOnClickListener {
                itemClick.invoke(notes)
            }

            deleteNoteImageView.setOnClickListener {
                deleteButtonClick.invoke(notes)
            }
        }
    }

    override fun getItemCount(): Int {
        return notesAdapterList.size
    }
}