package com.prado.taskmanager.activitys

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.prado.taskmanager.base.Constants

import com.prado.taskmanager.base.Routes
import com.prado.taskmanager.data.SharedPreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EditViewModel(
    private val localData: SharedPreference,
    private val navController: NavController) : ViewModel() {
    private var _isSaveRequest = MutableStateFlow(false)
    val isSaveRequest: StateFlow<Boolean> = _isSaveRequest

    fun setSaveRequest(value: Boolean){
        _isSaveRequest.value = value
    }
    private var _title = MutableStateFlow(localData.get(Constants.TITLE_KEY))
    val title: StateFlow<String?> = _title

    private var _description = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val description: StateFlow<String?> = _description

    fun editTask(){
        localData.save(Constants.TITLE_KEY, _title.value)
        localData.save(Constants.DESCRIPTION_KEY, _description.value)
        navController.navigate(Routes.TaskList.routes)
    }
    fun setTitle(screen: String){
        _title.value = screen
    }
    fun setDecription(screen: String){
        _description.value = screen
    }
}