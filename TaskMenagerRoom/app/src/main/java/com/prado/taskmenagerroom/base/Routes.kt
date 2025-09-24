package com.prado.taskmenagerroom.base

sealed class Routes(val routes: String) {
    data object TaskList : Routes(Constants.ROUTES.TASKLISTROUTE)
    data object TaskAdd : Routes(Constants.ROUTES.TASKADDROUTE)
    data object TaskEdit : Routes(Constants.ROUTES.TASKAEDITROUTE)
    data object TaskDetail : Routes(Constants.ROUTES.TASKADETEILROUTE)
}