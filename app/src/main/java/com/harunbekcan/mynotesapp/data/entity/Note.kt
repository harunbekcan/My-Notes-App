package com.harunbekcan.mynotesapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int? = null
) : Serializable