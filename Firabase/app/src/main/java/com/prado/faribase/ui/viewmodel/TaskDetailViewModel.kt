package com.prado.faribase.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prado.faribase.base.Constants
import com.prado.faribase.data.SharedPreference
import com.prado.faribase.data.TaskDatabase
import com.prado.faribase.data.TaskEntity
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

    private val _content = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val content : StateFlow<String> = _content

    fun loaTask(){
       viewModelScope.launch {
           _task.value = localDB.taskDao().getById(localData.getByID(Constants.TASK_KEY))
           _title.value = _task.value.title
           _content.value = _task.value.content

       }
    }

}