package com.prado.taskmenagerroom.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prado.taskmenagerroom.ui.theme.TaskMenagerRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskMenagerRoomTheme {
                Navigation().Create()
            }
        }
    }


}