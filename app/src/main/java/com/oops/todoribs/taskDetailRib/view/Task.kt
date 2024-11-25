package com.oops.todoribs.taskDetailRib.view

data class Task(
    val id: String,          // Unique identifier for the task
    val name: String,       // Name of the task
    val isCompleted: Boolean = false,  // Completion status
    val createdAt: Long = System.currentTimeMillis() // Timestamp for when the task was created
)
