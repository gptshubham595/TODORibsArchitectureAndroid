package com.oops.todoribs.taskDetailRib.router

import com.oops.todoribs.taskDetailRib.interactor.TaskDetailInteractor
import com.oops.todoribs.taskDetailRib.view.TaskDetailView
import com.uber.rib.core.ViewRouter

class TaskDetailRouter(
    interactor: TaskDetailInteractor,
    view: TaskDetailView
) : ViewRouter<TaskDetailView, TaskDetailInteractor>(view, interactor) {
    // Here you can define routing logic if you want to navigate to other RIBs from TaskDetail
}
