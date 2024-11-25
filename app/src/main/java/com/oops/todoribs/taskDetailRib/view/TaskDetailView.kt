package com.oops.todoribs.taskDetailRib.view

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.oops.todoribs.taskDetailRib.interactor.TaskDetailInteractor
import com.oops.todoribs.taskDetailRib.presentor.TaskDetailPresenter

class TaskDetailView(context: Context) : ViewGroup(context), TaskDetailPresenter {

    private val taskNameTextView: TextView
    private val deleteButton: Button

    init {
        // Initialize views
        taskNameTextView = TextView(context).apply {
            textSize = 20f
            setTextColor(Color.BLACK)
        }

        deleteButton = Button(context).apply {
            text = "Delete Task"
            setOnClickListener {
                showDeleteConfirmation()
            }
        }

        // Add views to the layout
        addView(taskNameTextView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        addView(deleteButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
    }

    override fun showTaskDetail(taskName: String) {
        taskNameTextView.text = taskName
    }

    override fun showDeleteConfirmation() {
        // Here you can implement a dialog, for simplicity showing a toast
        Toast.makeText(context, "Are you sure you want to delete this task?", Toast.LENGTH_SHORT).show()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }
}
