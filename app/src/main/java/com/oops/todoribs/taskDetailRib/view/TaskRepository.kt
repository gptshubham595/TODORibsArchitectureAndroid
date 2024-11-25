package com.oops.todoribs.taskDetailRib.view

interface TaskRepository {
    fun getTask(taskName: String): Task?
    fun deleteTask(taskName: String)
    // Other task-related methods can be added here
}
