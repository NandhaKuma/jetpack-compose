package com.task.jetpackcompose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoItem(
    @PrimaryKey val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)



