package com.oops.todoribs.taskCreationRib.presentor

interface TaskCreationPresenter {
    fun showTaskCreationSuccess(taskName: String)
    fun showTaskCreationError(message: String)
}
