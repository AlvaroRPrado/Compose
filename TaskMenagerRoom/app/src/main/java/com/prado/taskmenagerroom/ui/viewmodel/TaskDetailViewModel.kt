package com.prado.taskmenagerroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prado.taskmenagerroom.base.Constants
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase
import com.prado.taskmenagerroom.data.TaskEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskDetailViewModel(
    private val localData: SharedPreference,
    private val localDB: TaskDatabase): ViewModel() {


    private var _task = MutableStateFlow(TaskEntity())
    val task : StateFlow<TaskEntity> = _task

    private val _title = MutableStateFlow(localData.get(Constants.TITLE_KEY))
    val title : StateFlow<String?> = _title

    private val _description = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val description : StateFlow<String> = _description

    fun loaTask(){
       viewModelScope.launch {
           _task.value = localDB.taskDao().getById(localData.getByID(Constants.TASK_kEY))
           _title.value = _task.value.title
           _description.value = _task.value.content

       }
    }

}