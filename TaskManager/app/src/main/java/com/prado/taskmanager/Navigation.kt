package com.prado.taskmanager

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//Vai fazer o controle de navegação entre as telas.
class Navigation {
    private lateinit var navController: NavHostController
    private lateinit var localeData: SharedPreference

    @Composable
    fun Create(){
        navController = rememberNavController()
        localeData = SharedPreference(LocalContext.current)

        NavHost(navController = navController, startDestination = Routes.TaskList.routes){
            composable(route = Routes.TaskList.routes){
            CallScalffold(navController).CreateScreen(scree = Routes.TaskList.routes)
            }
            composable(Routes.TaskCreate.routes) {
                CallScalffold(navController).CreateScreen(scree = Routes.TaskCreate.routes)
            }
        }
    }
}