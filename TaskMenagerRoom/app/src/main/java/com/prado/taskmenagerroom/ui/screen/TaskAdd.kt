package com.prado.taskmenagerroom.ui.screen

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
import com.prado.taskmenagerroom.base.Constants
import com.prado.taskmenagerroom.ui.viewmodel.TaskCreateViewModel

@Composable
fun CreateTaskScreen(paddingValues: PaddingValues, createTaskViewModel: TaskCreateViewModel){
    val title by createTaskViewModel.title.collectAsState()
    val description by createTaskViewModel.content.collectAsState()
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
            value = description ?: "",
            onValueChange = {createTaskViewModel.setDescription(it)},
            label = { Text(Constants.DESCRIPTION) },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
       /* Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Button(onClick = {
                createTaskViewModel.createTask()
            }) {
                Text(text = "Criar")
            }
        }*/
    }
}

