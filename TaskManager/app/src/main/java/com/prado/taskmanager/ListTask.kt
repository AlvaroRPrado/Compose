package com.prado.taskmanager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prado.taskmanager.Constants.Companion.DESCRIPITION_KEY
import com.prado.taskmanager.Constants.Companion.TITLE_KEY


    @Composable
    fun ListTaskScreen(paddingValues: PaddingValues, navController: NavController){
        val localData = SharedPreference(LocalContext.current)
        Column (
            modifier = Modifier.padding(paddingValues)){
            Card {
                Text(text = localData.get(TITLE_KEY), modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp))
                Text(text = localData.get(DESCRIPITION_KEY), modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp))
            }
        }
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(10.dp),
            contentAlignment = Alignment.BottomEnd){
            FloatingActionButton(onClick = {
                navController.navigate(Routes.TaskCreate.routes)
            }) {
                Text(text = "+")
            }
        }
    }

