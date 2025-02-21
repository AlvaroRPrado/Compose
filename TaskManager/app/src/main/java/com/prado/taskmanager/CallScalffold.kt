package com.prado.taskmanager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class CallScalffold(val navController: NavController) {

    @Composable
    fun CreateScreen(scree: String): PaddingValues {
        Scaffold { padding ->
            when(scree){
                Routes.TaskList.routes -> ListTaskScreen(paddingValues = padding, navController = navController)
                Routes.TaskCreate.routes -> CreateTaskScreen(paddingValues = padding, navController = navController)
            }
        }
        return PaddingValues()
    }
}