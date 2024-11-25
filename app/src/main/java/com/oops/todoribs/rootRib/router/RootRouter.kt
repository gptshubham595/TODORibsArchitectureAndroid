package com.oops.todoribs.rootRib.router

import com.oops.todoribs.rootRib.interactor.RootInteractor
import com.oops.todoribs.taskListRib.builder.TaskListBuilder
import com.uber.rib.core.Router

class RootRouter(
    interactor: RootInteractor
) : Router<RootInteractor>(interactor) {

    fun attachTaskList() {
        val taskListRouter = TaskListBuilder(dependency).build()
        attachChild(taskListRouter)
        // Show the TaskListView
    }
}
