package com.task.jetpackcompose

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoItem::class], version = 3)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
