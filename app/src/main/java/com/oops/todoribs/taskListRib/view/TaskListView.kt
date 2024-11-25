package com.oops.todoribs.taskListRib.view;

import android.content.Context
import android.view.ViewGroup;
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oops.todoribs.taskListRib.presentor.TaskListPresenter

class TaskListView(context: Context) : ViewGroup(context), TaskListPresenter {

    private val taskAdapter = TaskAdapter(emptyList()) { task ->
        // Handle task click
        Toast.makeText(context, "Clicked on task: $task", Toast.LENGTH_SHORT).show()
    }

    init {
        val recyclerView = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = taskAdapter
        }

        // Add the RecyclerView to this ViewGroup
        addView(recyclerView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }

    override fun showTasks(tasks: List<String>) {
        taskAdapter.updateTasks(tasks) // Update the adapter with the new list of tasks
    }

    override fun showEmptyState() {
        Toast.makeText(context, "No tasks available", Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        TODO("Not yet implemented")
    }
}
