package com.prado.taskmenagerroom.base

sealed class Routes(val routes: String) {
    data object TaskList : Routes("taskList")
    data object TaskCreate : Routes("taskCreate")
    data object TaskEdit : Routes("taskEdit")
    data object TaskDetail : Routes("taskDetail")
}