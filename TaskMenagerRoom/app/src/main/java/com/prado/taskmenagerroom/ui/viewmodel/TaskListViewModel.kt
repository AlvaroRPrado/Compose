package com.prado.taskmenagerroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.prado.taskmenagerroom.base.Constants.Companion.DESCRIPTION_KEY
import com.prado.taskmenagerroom.base.Constants.Companion.TITLE_KEY
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase
import com.prado.taskmenagerroom.data.TaskEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskListViewModel(private val localData: SharedPreference,
                        private val localDB: TaskDatabase
) : ViewModel() {

    private var _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val tasks: StateFlow<List<TaskEntity>> = _tasks

    private var _title  = MutableStateFlow( localData.get(TITLE_KEY))
    val title: StateFlow<String?> = _title

    private var _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog

    fun loadsTasks(){
        try {
            viewModelScope.launch {
                _tasks.value = localDB.tastkDao().getAll()
            }
        }catch (ex: Exception){
            TODO()
        }
    }
    fun deleteTask(){
        localData.delete(TITLE_KEY)
        localData.delete(DESCRIPTION_KEY)
        _title.value = ""
        _showDialog.value = false
    }
    fun setShowDialog(value: Boolean){
        _showDialog.value = value
    }
    fun navigate(screen: String, navController: NavController){
        navController.navigate(screen)
    }
}