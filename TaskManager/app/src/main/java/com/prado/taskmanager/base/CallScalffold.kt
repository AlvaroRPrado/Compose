package com.prado.taskmanager.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.prado.taskmanager.activitys.CreateTaskScreen
import com.prado.taskmanager.activitys.DetailTaskScreen
import com.prado.taskmanager.activitys.EditTaskScreen
import com.prado.taskmanager.activitys.ListTaskScreen
import com.prado.taskmanager.data.SharedPreference

class CallScalffold(val navController: NavController) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CreateScreen(scree: String, localData: SharedPreference): PaddingValues {
        Scaffold (topBar = {
            when(scree){
                Routes.TaskList.routes -> CenterAlignedTopAppBar(title = { Text(text = "Minhas Notas") })
                Routes.TaskCreate.routes -> TopAppBar(
                        title = { Text(text = "Criar Nota")},
                        navigationIcon = { IconButton(onClick = {navController.navigate(Routes.TaskList.routes)}){
                           Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )
                Routes.TaskEdit.routes -> TopAppBar(
                        title = { Text(text = "Editar Nota")},
                        navigationIcon = { IconButton(onClick = {navController.navigate(Routes.TaskList.routes)}){
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )
                Routes.TaskDetail.routes -> TopAppBar(
                        title = { Text(text = "Detalhe da Nota") },
                        navigationIcon = { IconButton(onClick = {navController.navigate(Routes.TaskList.routes)}){
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )
            }
        }){ padding ->
            when(scree){
                Routes.TaskList.routes -> ListTaskScreen(paddingValues = padding, navController = navController)
                Routes.TaskCreate.routes -> CreateTaskScreen(paddingValues = padding, navController = navController)
                Routes.TaskEdit.routes -> EditTaskScreen(paddingValues = padding, navController = navController )
                Routes.TaskDetail.routes -> DetailTaskScreen(paddingValues = padding, localData = localData )
            }
        }
        return PaddingValues()
    }
}