package com.prado.taskmenagerroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.prado.taskmenagerroom.base.Constants
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskDetailViewModel(private val localData: SharedPreference, private val localDB: TaskDatabase): ViewModel() {

    private val _title = MutableStateFlow(localData.get(Constants.TITLE_KEY))
    val title : StateFlow<String?> = _title

    private val _description = MutableStateFlow(localData.get(Constants.DESCRIPTION_KEY))
    val description : StateFlow<String> = _description

    fun detailTask(){
        localData.get(Constants.TITLE_KEY)
        localData.get(Constants.DESCRIPTION_KEY)
    }

}