package com.prado.faribase.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prado.faribase.base.Constants
import com.prado.faribase.ui.viewmodel.TaskAddViewModel

@Composable
fun CreateTaskScreen(paddingValues: PaddingValues, createTaskViewModel: TaskAddViewModel){
    val title by createTaskViewModel.title.collectAsState()
    val content by createTaskViewModel.content.collectAsState()
    val saveRequest by createTaskViewModel.isSaveRequest.collectAsState()


    LaunchedEffect(saveRequest){
       if (saveRequest) createTaskViewModel.createTask()
    }
    Column (modifier = Modifier
        .padding(paddingValues)
        .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ){
        OutlinedTextField(
            value = title ?: "",
            onValueChange = {createTaskViewModel.setTile(it)},
            label = { Text(Constants.TITLE) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = content ?: "",
            onValueChange = {createTaskViewModel.setDescription(it)},
            label = { Text(Constants.CONTENT) },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
    }
}

