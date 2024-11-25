package com.oops.todoribs.taskDetailRib.components

import com.oops.todoribs.taskDetailRib.view.TaskRepository

interface ParentComponent {
    // Define any shared dependencies that TaskDetailRIB needs
    // For example, a repository interface
    fun taskRepository(): TaskRepository
}
