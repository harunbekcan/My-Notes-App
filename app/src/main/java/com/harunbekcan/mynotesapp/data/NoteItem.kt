package com.harunbekcan.mynotesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteItem (
    @PrimaryKey (autoGenerate = true)
    var id : Int ?= null,
    var title : String,
    var description : String
)