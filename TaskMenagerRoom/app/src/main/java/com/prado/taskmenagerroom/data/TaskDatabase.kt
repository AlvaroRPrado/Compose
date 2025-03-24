package com.prado.taskmenagerroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){

    abstract fun tastkDao() : TaskDao

    companion object{
        @Volatile
        private var  INSTANCE : TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val Instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = Instance
                return INSTANCE as TaskDatabase
            }
        }
    }
}