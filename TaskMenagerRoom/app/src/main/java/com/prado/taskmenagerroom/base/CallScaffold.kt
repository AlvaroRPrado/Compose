package com.prado.taskmenagerroom.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.prado.taskmenagerroom.ui.screen.CreateTaskScreen
import com.prado.taskmenagerroom.ui.viewmodel.TaskCreateViewModel
import com.prado.taskmenagerroom.ui.screen.DetailTaskScreen
import com.prado.taskmenagerroom.ui.viewmodel.TaskDetailViewModel
import com.prado.taskmenagerroom.ui.screen.EditTaskScreen
import com.prado.taskmenagerroom.ui.viewmodel.TaskEditViewModel
import com.prado.taskmenagerroom.ui.screen.ListTaskScreen
import com.prado.taskmenagerroom.ui.viewmodel.TaskListViewModel
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase


class CallScaffold(
    private val navController: NavController,
    localData: SharedPreference,
    localDB: TaskDatabase
) {
    private val createTaskViewModel = TaskCreateViewModel( navController = navController, localData = localData, localDB = localDB)
    private val editViewModel = TaskEditViewModel(navController = navController, localData = localData, localDB = localDB)
    private val listTaskViewModel = TaskListViewModel(localData = localData, localDB = localDB)
    private val detailViewModel = TaskDetailViewModel(localData = localData, localDB = localDB)

    @Composable
    fun CreateScreen(screen: String): PaddingValues {
        Scaffold (topBar = {
            when(screen){
                Routes.TaskList.routes -> ListTopBar()
                Routes.TaskCreate.routes -> CreateTopBar(createTaskViewModel)
                Routes.TaskEdit.routes -> EditTopBar(editViewModel)
                Routes.TaskDetail.routes -> DetailTopBar()
            }
        }){ padding ->
            when(screen){
                Routes.TaskList.routes -> ListTaskScreen(
                    paddingValues = padding,
                    navController = navController,
                    listTaskViewModel = listTaskViewModel
                )
                Routes.TaskCreate.routes -> CreateTaskScreen(
                    paddingValues = padding,
                    createTaskViewModel = createTaskViewModel,

                )
                Routes.TaskEdit.routes -> EditTaskScreen(
                    paddingValues = padding,
                    editViewModel = editViewModel
                )
                Routes.TaskDetail.routes -> DetailTaskScreen(
                    paddingValues = padding,
                    detailViewModel = detailViewModel
                )

            }
        }
        return PaddingValues()
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun DetailTopBar() {
        TopAppBar(
            title = { Text(text = Constants.TASK_DETAIL) },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Routes.TaskList.routes) }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            }
        )
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun EditTopBar(editViewModel: TaskEditViewModel) {
        TopAppBar(
            title = { Text(text = Constants.TASK_EDIT) },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Routes.TaskList.routes) }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {editViewModel.setSaveRequest(true)}) {
                    Icon(Icons.Default.Done, contentDescription = null)
                }
            }
        )
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun CreateTopBar(createTaskViewModel: TaskCreateViewModel) {
        TopAppBar(title = { Text(text = Constants.CREATE_TASK) },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Routes.TaskList.routes) }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {createTaskViewModel.setSaveRequest(true)}) {
                    Icon(Icons.Default.Done, contentDescription = null)
                }
            }
        )
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    private fun ListTopBar() {
        CenterAlignedTopAppBar(title = { Text(text = Constants.MY_TASK) })
    }
}