package com.example.uptodo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.uptodo.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    fun insert(data: TaskEntity)

    @Query("SELECT * FROM task ORDER BY date")
    fun getAllTask(id: Long): Flow<List<TaskEntity>>
}