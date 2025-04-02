package com.prado.taskmenagerroom.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prado.taskmenagerroom.base.Constants
import com.prado.taskmenagerroom.base.Routes
import com.prado.taskmenagerroom.data.TaskEntity
import com.prado.taskmenagerroom.ui.viewmodel.TaskListViewModel


@Composable
    fun ListTaskScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    listTaskViewModel: TaskListViewModel){

       // LaunchedEffect(key1 = Unit) { listTaskViewModel.loadsTasks() }
        LaunchedEffect(key1 = listTaskViewModel.tasks) { listTaskViewModel.loadsTasks() }
        val  tasks by listTaskViewModel.tasks.collectAsState()
        val showDialog by listTaskViewModel.showDialog.collectAsState(false)
        var selectItem by remember { mutableStateOf(TaskEntity()) }
        Column (
            modifier = Modifier.padding(paddingValues)){
          if (showDialog) {
              AlertDialog(onDismissRequest = {}, confirmButton = {
                  Button(onClick = {
                      listTaskViewModel.deleteTask(selectItem)
                  }) {
                      Text(text = Constants.YES)
                  }
              },
                  dismissButton = {
                      Button(onClick = {listTaskViewModel.setShowDialog(false)}) {
                          Text(text = Constants.NO)
                      }
                  },
                  text = { Text(text = Constants.CONFIRMA_DELETE) }
              )
          }
           if (tasks.isNotEmpty()) {
               LazyColumn {
                   tasks.forEach{ tasks ->
                       item {
                           Card(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(10.dp)
                                   .clickable { listTaskViewModel.navigate(Routes.TaskDetail.routes, navController)
                                       //navController.navigate(Routes.TaskDetail.routes)
                                   }
                           ) {

                               Row(
                                   modifier = Modifier.fillMaxWidth(),
                                   horizontalArrangement = Arrangement.SpaceBetween
                               ) {
                                   Text(
                                       text = tasks.title,
                                       modifier = Modifier.padding(
                                           start = 20.dp,
                                           end = 20.dp,
                                           top = 10.dp,
                                           bottom = 10.dp
                                       )
                                   )

                                   Box(modifier = Modifier) {
                                       Row {
                                           IconButton(onClick = { listTaskViewModel.navigate(Routes.TaskEdit.routes, navController)
                                               //navController.navigate(Routes.TaskEdit.routes)
                                           }) {
                                               Icon(Icons.Default.Edit, contentDescription = null)
                                           }
                                           IconButton(onClick = {
                                               selectItem = tasks
                                               listTaskViewModel.setShowDialog(true)
                                           }) {
                                               Icon(Icons.Default.Delete, contentDescription = null)
                                           }
                                       }

                                   }

                               }
                           }
                       }
                   }
               }

           }else{
               Box(modifier = Modifier
                   .fillMaxSize()
                   .padding(10.dp), contentAlignment = Alignment.Center){
                   Text(text = Constants.NO_TASK_SAVED)
               }

           }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(10.dp),
            contentAlignment = Alignment.BottomEnd){
            FloatingActionButton(onClick = {listTaskViewModel.navigate(Routes.TaskCreate.routes, navController)
                //navController.navigate(Routes.TaskCreate.routes)
            }) {
                Text(text = "+")
            }
        }
    }

