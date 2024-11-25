package com.oops.todoribs.taskListRib.presentor

interface TaskListPresenter {
    fun showTasks(tasks: List<String>) // Update the view with the list of tasks
    fun showEmptyState() // Show a message or state when there are no tasks
    fun showError(message: String) // Show an error message if something goes wrong
}
