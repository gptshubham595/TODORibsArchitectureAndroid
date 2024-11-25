package com.oops.todoribs.taskDetailRib.interactor

import com.oops.todoribs.taskDetailRib.presentor.TaskDetailPresenter
import com.oops.todoribs.taskDetailRib.router.TaskDetailRouter
import com.oops.todoribs.taskDetailRib.view.TaskRepository
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor

class TaskDetailInteractor(
    private val presenter: TaskDetailPresenter,
    private val taskRepository: TaskRepository // Injected dependency
) : Interactor<TaskDetailPresenter, TaskDetailRouter>() {

    private var taskName: String? = null

    fun setTask(taskName: String) {
        this.taskName = taskName
    }

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        taskName?.let {
            presenter.showTaskDetail(it)
        } ?: run {
            presenter.showTaskDetail("No task found")
        }
    }

    fun onDeleteTask() {
        presenter.showDeleteConfirmation()
        // Here you can add logic to actually delete the task using taskRepository
    }
}

