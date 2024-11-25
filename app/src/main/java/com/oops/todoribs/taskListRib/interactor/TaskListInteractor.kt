package com.oops.todoribs.taskListRib.interactor

import android.content.Context
import com.oops.todoribs.taskDetailRib.builder.TaskDetailBuilder
import com.oops.todoribs.taskListRib.presentor.TaskListPresenter
import com.oops.todoribs.taskListRib.router.TaskListRouter
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor

class TaskListInteractor(
    private val presenter: TaskListPresenter
) : Interactor<TaskListPresenter, TaskListRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        val tasks = loadTasks()
        if (tasks.isEmpty()) {
            presenter.showEmptyState()
        } else {
            presenter.showTasks(tasks)
        }
    }

    fun onTaskSelected(taskName: String) {
        // Assuming you have a context reference or can get it
        val taskDetailBuilder = TaskDetailBuilder()
        val taskDetailRouter = taskDetailBuilder.build(presenter as Context, taskName)

        // Attach the TaskDetailRIB (you may need to adjust this according to your RIB hierarchy)
        router.attachChild(taskDetailRouter)
    }

    private fun loadTasks(): List<String> {
        return listOf("Task 1", "Task 2", "Task 3")
    }
}
