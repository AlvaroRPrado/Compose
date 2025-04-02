package com.prado.taskmenagerroom.ui.viewmodel


import android.util.Log
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

class TaskCreateViewModel(
    private val localData: SharedPreference,
    private val navController: NavController,
    private val localDB: TaskDatabase) : ViewModel() {

    private var _title = MutableStateFlow(localData.get(Constants.TITLE_KEY))
    val title: StateFlow<String?> = _title
    private var _content = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val content: StateFlow<String?> = _content
    private var _isSaveRequest = MutableStateFlow(false)
    val isSaveRequest: StateFlow<Boolean> = _isSaveRequest

    fun setSaveRequest(value: Boolean){
        _isSaveRequest.value = value
    }

    fun createTask(){
      try {
          viewModelScope.launch {
              localDB.taskDao().insertAll(TaskEntity(id = 0, _title.value, _content.value))
              Log.i("database", "createTask: ${localDB.taskDao().getAll()}")
          }
          navigate(screen = Routes.TaskList.routes)
      }catch (ex: Exception){
          TODO()
      }


    }
    fun setTile(title: String){
        _title.value = title
    }
    fun setDescription(description: String){
        _content.value = description
    }
    private fun navigate(screen: String){
        navController.navigate(screen)
    }

}