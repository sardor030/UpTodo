package com.example.uptodo.di

import android.content.Context
import androidx.room.Room
import com.example.uptodo.data.dao.TaskDao
import com.example.uptodo.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(context,AppDatabase::class.java,"app_database").build()

    fun taskDao(database: AppDatabase): TaskDao = database.taskDao()
}