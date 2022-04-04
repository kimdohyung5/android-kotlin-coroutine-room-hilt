package com.kimdo.simpletodo.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimdo.simpletodo.db.TodoModel
import com.kimdo.simpletodo.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repository: TodoRepository): ViewModel() {

    fun insertTodo(todoModel: TodoModel) = viewModelScope.launch { repository.insertTodo(todoModel) }
    fun getTodoList() =  repository.getTodoList()
}