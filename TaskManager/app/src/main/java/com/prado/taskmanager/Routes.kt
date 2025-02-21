package com.prado.taskmanager

sealed class Routes(val routes: String) {
    data object TaskList : Routes("taskList")
    data object TaskCreate : Routes("taskCreate")
}