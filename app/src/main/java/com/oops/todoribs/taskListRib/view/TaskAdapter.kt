package com.oops.todoribs.taskListRib.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oops.todoribs.R

class TaskAdapter(
    private var tasks: List<String> = emptyList(),
    private val onTaskClick: (String) -> Unit // Callback for when a task is clicked
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder class to hold the task item views
    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskName: TextView = itemView.findViewById(R.id.task_name)
    }

    // Create the ViewHolder by inflating the task_item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    // Bind the task data to the ViewHolder
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskName.text = task

        // Set a click listener for each task item
        holder.itemView.setOnClickListener {
            onTaskClick(task)
        }
    }

    // Return the total number of tasks
    override fun getItemCount(): Int = tasks.size

    // Update the task list and refresh the adapter
    fun updateTasks(newTasks: List<String>) {
        tasks = newTasks
        notifyDataSetChanged() // Notify the adapter to refresh the UI
    }
}
