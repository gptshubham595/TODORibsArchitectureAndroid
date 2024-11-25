package com.oops.todoribs.taskCreationRib.view

import android.content.Context
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.oops.todoribs.taskCreationRib.interactor.TaskCreationInteractor
import com.oops.todoribs.taskCreationRib.presentor.TaskCreationPresenter

class TaskCreationView(context: Context) : ViewGroup(context), TaskCreationPresenter {

    private val taskNameEditText: EditText
    private val createButton: Button

    init {
        // Initialize views
        taskNameEditText = EditText(context).apply {
            hint = "Enter task name"
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }

        createButton = Button(context).apply {
            text = "Create Task"
            setOnClickListener {
                createTask(taskNameEditText.text.toString())
            }
        }

        // Add views to the layout
        addView(taskNameEditText)
        addView(createButton)
    }

    private fun createTask(taskName: String) {
        if (taskName.isBlank()) {
            showTaskCreationError("Task name cannot be empty")
        } else {
            // Assuming the interactor will handle the task creation logic
            (context as? TaskCreationInteractor)?.onCreateTask(taskName)
        }
    }

    override fun showTaskCreationSuccess(taskName: String) {
        Toast.makeText(context, "Task '$taskName' created successfully!", Toast.LENGTH_SHORT).show()
        // Optionally clear the input field
        taskNameEditText.text.clear()
    }

    override fun showTaskCreationError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }
}
