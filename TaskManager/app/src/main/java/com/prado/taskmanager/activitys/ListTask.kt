package com.prado.taskmanager.activitys

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prado.taskmanager.base.Constants.Companion.TITLE
import com.prado.taskmanager.base.Routes
import com.prado.taskmanager.data.SharedPreference


@Composable
    fun ListTaskScreen(paddingValues: PaddingValues, navController: NavController, listTaskViewModel: ListTaskViewModel){
        val localData = SharedPreference(LocalContext.current)
        val title by listTaskViewModel.title.collectAsState()
        val showDialog by listTaskViewModel.showDialog.collectAsState(false)

        Column (
            modifier = Modifier.padding(paddingValues)){
          if (showDialog) {
              AlertDialog(onDismissRequest = {}, confirmButton = {
                  Button(onClick = {
                      listTaskViewModel.deleteTask()
                  }) {
                      Text(text = "Sim")
                  }
              },
                  dismissButton = {
                      Button(onClick = {listTaskViewModel.setShowDialog(false)}) {
                          Text(text = "Não")
                      }
                  },
                  text = { Text(text = "Deseja excluir essa tarefa?") }
              )
          }
           if (title != "") {
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
                           text = localData.get(TITLE),
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
                                   listTaskViewModel.setShowDialog(true)
                               }) {
                                   Icon(Icons.Default.Delete, contentDescription = null)
                               }
                           }

                       }

                   }
               }
           }else{
               Box(modifier = Modifier
                   .fillMaxSize()
                   .padding(10.dp), contentAlignment = Alignment.Center){
                   Text(text = "Não tem nenhuma tarefa salva!")
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

