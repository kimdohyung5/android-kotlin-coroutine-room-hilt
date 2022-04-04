package com.kimdo.simpletodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimdo.simpletodo.databinding.TodoItemBinding
import com.kimdo.simpletodo.db.TodoModel

class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {

    private var todoItems: List<TodoModel> = listOf()

    class MyViewHolder(var binding:TodoItemBinding): RecyclerView.ViewHolder(binding.root)

    fun setTodoItems(todoItems: List<TodoModel>) {
        this.todoItems = todoItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from( parent.context)
        val binding = TodoItemBinding.inflate(inflator, parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.title.text = todoItems[position].title.toString()
        holder.binding.content.text = todoItems[position].description.toString()
        holder.binding.regdate.text = todoItems[position].createdDate.toString()
    }
    override fun getItemCount(): Int = todoItems.size
}