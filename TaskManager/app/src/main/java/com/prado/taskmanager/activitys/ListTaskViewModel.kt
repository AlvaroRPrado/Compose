package com.prado.taskmanager.activitys

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.prado.taskmanager.base.Constants.Companion.DESCRIPTION_KEY
import com.prado.taskmanager.base.Constants.Companion.TITLE_KEY
import com.prado.taskmanager.data.SharedPreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListTaskViewModel(private val localData: SharedPreference) : ViewModel() {

    private var _title  = MutableStateFlow( localData.get(TITLE_KEY))
    val title: StateFlow<String?> = _title
    private var _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog

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