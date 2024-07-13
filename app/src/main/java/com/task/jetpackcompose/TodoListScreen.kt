package com.task.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color

//@Composable
//fun TodoListScreen(viewModel: TodoViewModel, navController: NavController) {
//    val todoList = viewModel.todoList.collectAsLazyPagingItems()
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        LazyColumn {
//            items(todoList) { todo ->
//                todo?.let {
//                    TodoItemRow(todo = it, onClick = {
//                        viewModel.fetchTodoItem(it.id)
//                        navController.navigate("todoDetail/${it.id}")
//                    })
//                }
//            }
//            item {
//                Spacer(modifier = Modifier.height(16.dp))
//                Button(
//                    onClick = { navController.navigate("todoDetail/0") },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text("Add New Task")
//                }
//            }
//        }
//    }
//}


@Composable
fun TodoListScreen(viewModel: TodoViewModel, navController: NavController) {
    val todoList = viewModel.todoList.collectAsLazyPagingItems()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(todoList) { todo ->
                todo?.let {
                    TodoItemRow(todo = it, onClick = {
                        viewModel.fetchTodoItem(it.id)
                        navController.navigate("todoDetail/${it.id}")
                    })
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("todoDetail/0") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add New Task")
                }
            }
        }
    }
}

@Composable
fun TodoItemRow(todo: TodoItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = todo.todo)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = if (todo.completed) "Completed" else "Pending")
        }
        Checkbox(checked = todo.completed, onCheckedChange = null)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoListScreen() {

}
