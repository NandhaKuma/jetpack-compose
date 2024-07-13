package com.task.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                val viewModel: TodoViewModel = viewModel()

                NavHost(navController = navController, startDestination = "todoList") {
                    composable("todoList") {
                        TodoListScreen(viewModel, navController)
                    }
                    composable("todoDetail/{todoId}") { backStackEntry ->
                        val todoId = backStackEntry.arguments?.getString("todoId")?.toIntOrNull()
                        val todo = viewModel.selectedTodo.collectAsState().value
                        TodoDetailScreen(
                            todo = todo,
                            onBack = { navController.popBackStack() },
                            onAdd = { viewModel.addTodoItem(it) },
                            onUpdate = { viewModel.updateTodoItem(it.id, it) },
                            onDelete = { viewModel.deleteTodoItem(it) }
                        )
                    }
                }
            }
        }
    }
}


