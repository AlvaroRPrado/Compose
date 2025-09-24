package com.prado.faribase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prado.faribase.base.Constants

@Entity(tableName = "taskEntity")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Long = 0L,
    @ColumnInfo(Constants.DATABASE.TITLECOLUMN) val title: String = "",
    @ColumnInfo(Constants.DATABASE.CONTENTCOLUNN) val content: String = ""
)