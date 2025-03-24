package com.prado.taskmenagerroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Insert
    fun insertAll(vararg taskEntity: TaskEntity)

    @Update
    fun update(vararg taskEntity: TaskEntity)

    @Delete
    fun delete(vararg taskEntity: TaskEntity)

    @Query("SELECT * FROM taskEntity")
    fun getAll(vararg taskEntity: TaskEntity)
}