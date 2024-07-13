package com.task.jetpackcompose

data class TodoResponse(
    val todos: List<TodoItem>,
    val total: Int,
    val skip: Int,
    val limit: Int
)