package com.kimdo.simpletodo.repository


import com.kimdo.simpletodo.db.TodoDao
import com.kimdo.simpletodo.db.TodoModel
import javax.inject.Inject

class TodoRepository  @Inject constructor(private var todoDao: TodoDao) {

    fun getTodoList() = todoDao.getTodoList()
    suspend fun insertTodo(todoModel: TodoModel)  = todoDao.insertTodo(todoModel)
}