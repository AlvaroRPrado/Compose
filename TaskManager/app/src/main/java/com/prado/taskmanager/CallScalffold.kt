package com.prado.taskmanager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class CallScalffold(val navController: NavController) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CreateScreen(scree: String): PaddingValues {
        Scaffold (topBar = {
            when(scree){
                Routes.TaskList.routes -> CenterAlignedTopAppBar(title = { Text(text = "Minhas Notas") })
                Routes.TaskCreate.routes -> TopAppBar(title = { Text(text = "Criar Nota") })
            }
        }){ padding ->
            when(scree){
                Routes.TaskList.routes -> ListTaskScreen(paddingValues = padding, navController = navController)
                Routes.TaskCreate.routes -> CreateTaskScreen(paddingValues = padding, navController = navController)
            }
        }
        return PaddingValues()
    }
}