package com.task.jetpackcompose

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TodoRepository @Inject constructor(
    private val apiService: TodoApiService,
    private val todoDao: TodoDao
) {

    fun getTodoList(): Flow<PagingData<TodoItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 3,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TodoPagingSource(apiService) }
        ).flow
    }

    fun getAllTodos(): Flow<List<TodoItem>> {
        return todoDao.getAllTodos()
    }

    suspend fun getTodoItem(id: Int): TodoItem? {
        return todoDao.getTodoById(id) ?: apiService.getTodoItem(id).apply {
            todoDao.insertTodoItem(this)
        }
    }

    suspend fun addTodoItem(todoItem: TodoItem) {
        todoDao.insertTodoItem(todoItem)
        if (isOnline()) {
            apiService.addTodoItem(todoItem)
        }
    }

    suspend fun updateTodoItem(id: Int, todoItem: TodoItem) {
        todoDao.insertTodoItem(todoItem)
        if (isOnline()) {
            apiService.updateTodoItem(id, todoItem)
        }
    }

    suspend fun deleteTodoItem(id: Int) {
        todoDao.deleteTodoItemById(id)
        if (isOnline()) {
            apiService.deleteTodoItem(id)
        }
    }

    private fun isOnline(): Boolean {
        // Implement network check
        return true // Replace with actual network connectivity check
    }
}


