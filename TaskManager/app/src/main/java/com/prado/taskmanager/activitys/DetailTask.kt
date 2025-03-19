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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailTaskScreen(paddingValues: PaddingValues, detailViewModel: DetailViewModel){

    val title by detailViewModel.title.collectAsState()
    val description by detailViewModel.description.collectAsState()

    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize().padding(10.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = title ?: "",
                modifier = Modifier.padding(10.dp) )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.weight(1f).fillMaxSize()) {
            Text(text = description?: "",
                modifier = Modifier.padding(10.dp))
        }
    }
}