package com.example.uptodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("date") val date: String,
    @ColumnInfo("time") val time: String,
    @ColumnInfo("desc") val desc: String,
    @ColumnInfo("priority") val priority: Int
)
