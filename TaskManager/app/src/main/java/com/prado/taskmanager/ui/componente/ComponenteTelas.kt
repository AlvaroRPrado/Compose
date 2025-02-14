package com.prado.taskmanager.ui.componente

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prado.taskmanager.ui.theme.TaskManagerTheme

@Composable
fun CreateTaskScreen(paddingValues: PaddingValues){
    var title by remember { mutableStateOf(" ") }
    var description by remember { mutableStateOf(" ") }
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
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Button(onClick = {
                Log.i("info", "CreateTaskCreen :\n" +
                        " Titulo: $title\n" +
                        ", Descrição: $description")
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
        CreateTaskScreen(PaddingValues())
    }
}