package com.oops.todoribs.taskCreationRib.interactor

import com.oops.todoribs.taskCreationRib.presentor.TaskCreationPresenter
import com.oops.todoribs.taskCreationRib.router.TaskCreationRouter
import com.uber.rib.core.Interactor

class TaskCreationInteractor(
    private val presenter: TaskCreationPresenter
) : Interactor<TaskCreationPresenter, TaskCreationRouter>() {

    fun onCreateTask(taskName: String) {
        if (taskName.isNotBlank()) {
            // Here you would normally add the task to a data source
            presenter.showTaskCreationSuccess(taskName)
        } else {
            presenter.showTaskCreationError("Task name cannot be empty")
        }
    }
}
