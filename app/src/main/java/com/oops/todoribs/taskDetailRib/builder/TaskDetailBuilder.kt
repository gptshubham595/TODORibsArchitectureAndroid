package com.oops.todoribs.taskDetailRib.builder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.oops.todoribs.taskDetailRib.components.ParentComponent
import com.oops.todoribs.taskDetailRib.interactor.TaskDetailInteractor
import com.oops.todoribs.taskDetailRib.router.TaskDetailRouter
import com.oops.todoribs.taskDetailRib.view.TaskDetailView
import com.uber.rib.core.ViewBuilder

class TaskDetailBuilder(dependency: ParentComponent) :
    ViewBuilder<TaskDetailView, TaskDetailRouter, ParentComponent>(dependency) {

    override fun build(context: Context): TaskDetailRouter {
        // Create the view
        val taskDetailView = TaskDetailView(context)

        // Create the presenter (the view is implementing the presenter interface)
        val taskDetailPresenter = taskDetailView

        // Create the interactor, possibly using a repository from the parent component
        val taskDetailInteractor =
            TaskDetailInteractor(taskDetailPresenter, dependency.taskRepository())

        // Create and return the router
        return TaskDetailRouter(taskDetailInteractor, taskDetailView)
    }

    override fun inflateView(
        inflater: LayoutInflater?,
        parentViewGroup: ViewGroup?
    ): TaskDetailView {
        TODO("Not yet implemented")
    }
}

