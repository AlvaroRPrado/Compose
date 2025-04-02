package com.prado.taskmenagerroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg taskEntity: TaskEntity)

    @Update
    suspend fun update(vararg taskEntity: TaskEntity)

    @Delete
   suspend fun delete(vararg taskEntity: TaskEntity)

    @Query("SELECT * FROM taskEntity")
    suspend fun getAll(): List<TaskEntity>

    //4 edit
    @Query("SELECT * FROM taskEntity WHERE id LIKE(:id)")
    suspend fun getById(id: Long): TaskEntity
}