package com.prado.taskmenagerroom.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase

//Vai fazer o controle de navegação entre as telas.
class Navigation {

    private lateinit var navController: NavHostController
    private lateinit var localeData: SharedPreference
    private lateinit var localDB: TaskDatabase

    private fun NavGraphBuilder.composableScreen(routes: String){
        composable(routes){
            CallScaffold(navController, localeData, localDB = localDB).CreateScreen(screen = routes)
        }
    }

    @Composable
    fun Create(){
        navController = rememberNavController()
        localeData = SharedPreference(LocalContext.current)
        localDB = TaskDatabase.getDatabase(LocalContext.current)

        NavHost(navController = navController, startDestination = Routes.TaskList.routes){
            //Refatorando o codigo
            composableScreen(Routes.TaskList.routes)
            composableScreen(Routes.TaskCreate.routes)
            composableScreen(Routes.TaskDetail.routes)
            composableScreen(Routes.TaskEdit.routes)
           /* composable(route = Routes.TaskList.routes){
            CallScalffold(navController).CreateScreen(scree = Routes.TaskList.routes, localData = localeData)
            }
            composable(Routes.TaskCreate.routes) {
                CallScalffold(navController).CreateScreen(scree = Routes.TaskCreate.routes, localData = localeData)
            }
            composable(Routes.TaskEdit.routes) {
                CallScalffold(navController).CreateScreen(scree = Routes.TaskEdit.routes, localData = localeData)
            }
            composable(Routes.TaskDetail.routes) {
                CallScalffold(navController).CreateScreen(scree = Routes.TaskDetail.routes, localData = localeData)
            }*/
        }

    }
}