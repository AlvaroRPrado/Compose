package com.prado.taskmenagerroom.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.prado.taskmenagerroom.base.Constants
import com.prado.taskmenagerroom.base.Routes
import com.prado.taskmenagerroom.data.SharedPreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskCreateViewModel(
    private val localData: SharedPreference,
    private val navController: NavController) : ViewModel() {

    private var _title = MutableStateFlow(localData.get(Constants.TITLE_KEY))
    val title: StateFlow<String?> = _title
    private var _description = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val description: StateFlow<String?> = _description
    private var _isSaveRequest = MutableStateFlow(false)
    val isSaveRequest: StateFlow<Boolean> = _isSaveRequest

    fun setSaveRequest(value: Boolean){
        _isSaveRequest.value = value
    }

    fun createTask(){
        localData.save(Constants.TITLE_KEY, _title.value ?: "")
        localData.save(Constants.DESCRIPTION_KEY, _description.value ?: "")

        navigate(screen = Routes.TaskList.routes)
    }
    fun setTile(title: String){
        _title.value = title
    }
    fun setDescription(description: String){
        _description.value = description
    }
    private fun navigate(screen: String){
        navController.navigate(screen)
    }

}