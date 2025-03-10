package com.prado.taskmanager.activitys

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prado.taskmanager.base.Constants.Companion.DESCRIPTION
import com.prado.taskmanager.base.Constants.Companion.TITLE
import com.prado.taskmanager.base.Routes
import com.prado.taskmanager.data.SharedPreference
import com.prado.taskmanager.ui.theme.TaskManagerTheme

@Composable
fun CreateTaskScreen(paddingValues: PaddingValues, navController: NavController){
    var title by remember { mutableStateOf(" ") }
    var description by remember { mutableStateOf(" ") }
    val localData = SharedPreference(LocalContext.current)
    Column (modifier = Modifier
        .padding(paddingValues)
        .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ){
        OutlinedTextField(
            value = title,
            onValueChange = {title = it},
            label = { Text("Titulo") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = {description = it},
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Button(onClick = {
                localData.save(TITLE, title)
                localData.save(DESCRIPTION, description)
                Log.i("info", "CreateTaskCreen : ${localData.get(TITLE)}, ${localData.get(
                    DESCRIPTION
                )}")
                navController.navigate(Routes.TaskList.routes)
            }) {
                Text(text = "Criar")
            }
        }
    }
}

@Preview(showBackground = true)
//@Preview(showBackground = true, device = Devices.DESKTOP)
@Composable
private fun MainPreview() {
    TaskManagerTheme { 
        CreateTaskScreen(
            PaddingValues(),
            navController = TODO()
        )
    }
}