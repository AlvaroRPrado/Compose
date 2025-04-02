package com.prado.taskmenagerroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.prado.taskmenagerroom.base.Constants

import com.prado.taskmenagerroom.base.Routes
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase
import com.prado.taskmenagerroom.data.TaskEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskEditViewModel(
    private val localData: SharedPreference,
    private val navController: NavController,
    private val localDB: TaskDatabase
) : ViewModel() {

    private var _isSaveRequest = MutableStateFlow(false)
    val isSaveRequest: StateFlow<Boolean> = _isSaveRequest

    private var _title = MutableStateFlow("")
    val title: StateFlow<String?> = _title

    private var _description = MutableStateFlow("")
    val description: StateFlow<String?> = _description

    // 3 edit
    private var _task = MutableStateFlow(TaskEntity())
    val task: StateFlow<TaskEntity> = _task


    fun setSaveRequest(value: Boolean){
        _isSaveRequest.value = value
    }
    fun editTask(){
        try {
            //9 edit
            viewModelScope.launch {
                localDB.taskDao().update(TaskEntity(_task.value.id, _title.value, _description.value))
                navController.navigate(Routes.TaskList.routes)
            }
        }catch (ex: Exception){
            TODO()
        }
    }
    fun setTitle(screen: String){
        _title.value = screen
    }
    fun setDescription(screen: String){
        _description.value = screen
    }
    //6 edit
    fun loadsTask(){
        try {
            viewModelScope.launch {
                _task.value = localDB.taskDao().getById(localData.getByID(Constants.TASK_kEY))
                setTitle(_task.value.title)
                setDescription(_task.value.content)
            }
        }catch (ex: Exception){
            TODO()
        }
    }

}