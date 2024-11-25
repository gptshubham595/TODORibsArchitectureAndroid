package com.oops.todoribs.taskCreationRib.router

import com.oops.todoribs.taskCreationRib.interactor.TaskCreationInteractor
import com.oops.todoribs.taskCreationRib.view.TaskCreationView
import com.uber.rib.core.ViewRouter

class TaskCreationRouter(
    interactor: TaskCreationInteractor,
    view: TaskCreationView
) : ViewRouter<TaskCreationView, TaskCreationInteractor>(view, interactor) {
    // Here you can define routing logic if you want to navigate to other RIBs after task creation
}
