package com.prado.taskmanager.activitys

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prado.taskmanager.base.Constants
import com.prado.taskmanager.data.SharedPreference

@Composable
fun DetailTaskScreen(paddingValues: PaddingValues, localData: SharedPreference){
   val title by remember { mutableStateOf(localData.get(Constants.TITLE_KEY) ?: "") }
    val description by remember { mutableStateOf(localData.get(Constants.DESCRIPITION_KEY) ?: "") }
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize().padding(10.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = title, modifier = Modifier.padding(10.dp) )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.weight(1f).fillMaxSize()) {
            Text(text = description, modifier = Modifier.padding(10.dp))
        }





    }
}