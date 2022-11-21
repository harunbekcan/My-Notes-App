package com.harunbekcan.mynotesapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
    var title : String,
    var description : String,
    @PrimaryKey (autoGenerate = true)
    var id : Int ?= null
)