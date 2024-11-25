package com.oops.todoribs.taskCreationRib.builder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.oops.todoribs.taskCreationRib.interactor.TaskCreationInteractor
import com.oops.todoribs.taskCreationRib.router.TaskCreationRouter
import com.oops.todoribs.taskCreationRib.view.TaskCreationView
import com.oops.todoribs.taskDetailRib.components.ParentComponent
import com.uber.rib.core.ViewBuilder

class TaskCreationBuilder(dependency: ParentComponent) :
    ViewBuilder<TaskCreationView, TaskCreationRouter, ParentComponent>(dependency) {

    fun build(context: Context): TaskCreationRouter {
        // Create the view
        val taskCreationView = TaskCreationView(context)

        // Create the presenter (the view is implementing the presenter interface)
        val taskCreationPresenter = taskCreationView

        // Create the interactor
        val taskCreationInteractor = TaskCreationInteractor(taskCreationPresenter)

        // Create and return the router
        return TaskCreationRouter(taskCreationInteractor, taskCreationView)
    }

    override fun inflateView(
        inflater: LayoutInflater?,
        parentViewGroup: ViewGroup?
    ): TaskCreationView {
        TODO("Not yet implemented")
    }
}
