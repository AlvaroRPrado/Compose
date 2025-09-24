package com.prado.taskmenagerroom.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.prado.taskmenagerroom.data.SharedPreference
import com.prado.taskmenagerroom.data.TaskDatabase
import com.prado.taskmenagerroom.ui.screen.CreateTaskScreen
import com.prado.taskmenagerroom.ui.screen.DetailTaskScreen
import com.prado.taskmenagerroom.ui.screen.EditTaskScreen
import com.prado.taskmenagerroom.ui.screen.ListTaskScreen
import com.prado.taskmenagerroom.ui.viewmodel.TaskAddViewModel
import com.prado.taskmenagerroom.ui.viewmodel.TaskDetailViewModel
import com.prado.taskmenagerroom.ui.viewmodel.TaskEditViewModel
import com.prado.taskmenagerroom.ui.viewmodel.TaskListViewModel


class CallScaffold(
    private val navController: NavController,
    localData: SharedPreference,
    localDB: TaskDatabase
) {
    private val createTaskViewModel by lazy { TaskAddViewModel(navController = navController, localDB = localDB) }
    private val editViewModel by lazy { TaskEditViewModel(navController = navController,
        localData = localData, localDB = localDB) }
    private val listTaskViewModel by lazy { TaskListViewModel(localData = localData, localDB = localDB) }
    private val detailViewModel by lazy { TaskDetailViewModel(localData = localData, localDB = localDB) }

    @Composable
    fun buildScreen(screen: String): PaddingValues {
        val viewModel =  when(screen){
            Routes.TaskList.routes -> listTaskViewModel
            Routes.TaskAdd.routes -> createTaskViewModel
            Routes.TaskEdit.routes -> editViewModel
            Routes.TaskDetail.routes -> detailViewModel
            else -> throw IllegalArgumentException("Não foi encontrada a tela $screen")
        }
        Scaffold (topBar = { CustomTopBar(screen = screen, viewModel = viewModel { viewModel }) }){ padding ->
            when(screen){
                Routes.TaskList.routes -> ListTaskScreen(
                    paddingValues = padding,
                    navController = navController,
                    listTaskViewModel = listTaskViewModel
                )
                Routes.TaskAdd.routes -> CreateTaskScreen(
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
    fun ButtonSave(onSaveClick: () -> Unit){
        IconButton(onClick = onSaveClick){
            Icon(
                Icons.Default.Done,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.size(25.dp)
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CustomTopBar(screen: String, viewModel: ViewModel){
        val title = when(screen){
            Routes.TaskAdd.routes -> Constants.TOPAPPBARHEADER.CREATE_TASK
            Routes.TaskEdit.routes -> Constants.TOPAPPBARHEADER.TASK_EDIT
            Routes.TaskList.routes -> Constants.TOPAPPBARHEADER.MY_TASK
            Routes.TaskDetail.routes -> Constants.TOPAPPBARHEADER.TASK_DETAIL
            else -> ""
        }

        CenterAlignedTopAppBar(title = {Text(text = title)},
            actions = {
                when(viewModel){
                    is TaskAddViewModel -> ButtonSave(onSaveClick = {createTaskViewModel.setSaveRequest(true)})
                    is TaskEditViewModel -> ButtonSave(onSaveClick = {editViewModel.setSaveRequest(true)})
                }

            }, navigationIcon = {
                if (viewModel !is TaskListViewModel) {
                    IconButton(onClick = { navController.navigate(Routes.TaskList.routes) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                }
            })
    }
}