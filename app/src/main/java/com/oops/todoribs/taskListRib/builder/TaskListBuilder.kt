package com.oops.todoribs.taskListRib.builder

import com.oops.todoribs.taskListRib.components.TaskListDependency
import com.oops.todoribs.taskListRib.interactor.TaskListInteractor
import com.oops.todoribs.taskListRib.router.TaskListRouter

class TaskListBuilder(dependency: TaskListDependency) : Builder<TaskListDependency>(dependency) {
    fun build(): TaskListRouter {
        val interactor = TaskListInteractor()
        val view = TaskListView()
        return TaskListRouter(view, interactor)
    }
}