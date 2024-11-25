package com.oops.todoribs.taskListRib.router

import com.oops.todoribs.taskCreationRib.builder.TaskCreationBuilder
import com.oops.todoribs.taskDetailRib.builder.TaskDetailBuilder
import com.oops.todoribs.taskDetailRib.components.ParentComponent
import com.oops.todoribs.taskDetailRib.interactor.TaskDetailInteractor
import com.oops.todoribs.taskDetailRib.view.TaskRepository
import com.oops.todoribs.taskListRib.interactor.TaskListInteractor
import com.oops.todoribs.taskListRib.view.TaskListView
import com.uber.rib.core.ViewRouter

class TaskListRouter(
    interactor: TaskListInteractor,
    view: TaskListView
) : ViewRouter<TaskListView, TaskListInteractor>(view, interactor) {

    // Attach the TaskDetailRIB when a task is selected
    fun attachTaskDetailRIB(taskName: String) {
        val taskDetailBuilder = TaskDetailBuilder(object : ParentComponent {
            override fun taskRepository(): TaskRepository {
                // Return the repository instance from the parent component
                return (interactor as TaskListInteractor).taskRepository()
            }
        })
        val taskDetailRouter = taskDetailBuilder.build(view.context)

        // Set the task in the interactor
        (taskDetailRouter.interactor as TaskDetailInteractor).setTask(taskName)

        // Attach the child RIB
        attachChild(taskDetailRouter)

        // Optionally, if you want to navigate to the task detail view
        view.showTaskDetailView(taskDetailRouter)
    }

    // Optionally, add methods to detach the child RIB when done
    fun detachTaskDetailRIB() {
        val taskDetailRouter = findChild(TaskDetailRouter::class.java)
        taskDetailRouter?.let {
            detachChild(it)
            it.removeView()
        }
    }

    // Attach the TaskCreationRIB
    fun attachTaskCreationRIB() {
        val taskCreationBuilder = TaskCreationBuilder(object : ParentComponent {
            override fun taskRepository(): TaskRepository {
                // Return the repository instance from the parent component
                return (interactor as TaskListInteractor).taskRepository()
            }
        })
        val taskCreationRouter = taskCreationBuilder.build(view.context)

        // Attach the child RIB
        attachChild(taskCreationRouter)

        // Optionally, navigate to the task creation view
        view.showTaskCreationView(taskCreationRouter)
    }

}
