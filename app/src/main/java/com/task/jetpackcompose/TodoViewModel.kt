package com.task.jetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//class TodoViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {
//    val todoList: Flow<PagingData<TodoItem>> = repository.getTodoList().cachedIn(viewModelScope)
//
//    private val _selectedTodo = MutableStateFlow<TodoItem?>(null)
//    val selectedTodo: StateFlow<TodoItem?> = _selectedTodo
//
//    fun fetchTodoItem(id: Int) {
//        viewModelScope.launch {
//            val todo = repository.getTodoItem(id)
//            _selectedTodo.value = todo
//        }
//    }
//
//    fun addTodoItem(todoItem: TodoItem) {
//        viewModelScope.launch {
//            repository.addTodoItem(todoItem)
//        }
//    }
//
//    fun updateTodoItem(id: Int, todoItem: TodoItem) {
//        viewModelScope.launch {
//            repository.updateTodoItem(id, todoItem)
//        }
//    }
//
//    fun deleteTodoItem(id: Int) {
//        viewModelScope.launch {
//            repository.deleteTodoItem(id)
//        }
//    }
//}




class TodoViewModel @Inject constructor (private val repository: TodoRepository) : ViewModel() {

    val todoList: Flow<PagingData<TodoItem>> = repository.getTodoList().cachedIn(viewModelScope)

    private val _selectedTodo = MutableStateFlow<TodoItem?>(null)
    val selectedTodo: StateFlow<TodoItem?> = _selectedTodo

    fun fetchTodoItem(id: Int) {
        viewModelScope.launch {
            _selectedTodo.value = repository.getTodoItem(id)
        }
    }

    fun addTodoItem(todoItem: TodoItem) {
        viewModelScope.launch {
            repository.addTodoItem(todoItem)
        }
    }

    fun updateTodoItem(id: Int, todoItem: TodoItem) {
        viewModelScope.launch {
            repository.updateTodoItem(id, todoItem)
        }
    }

    fun deleteTodoItem(id: Int) {
        viewModelScope.launch {
            repository.deleteTodoItem(id)
        }
    }
}


