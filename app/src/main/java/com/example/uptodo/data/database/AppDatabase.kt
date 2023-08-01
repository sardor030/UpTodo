package com.example.uptodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.uptodo.data.dao.TaskDao
import com.example.uptodo.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao
}