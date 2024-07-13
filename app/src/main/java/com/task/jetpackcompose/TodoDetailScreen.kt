package com.task.jetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TodoDetailScreen(
    todo: TodoItem?,
    onBack: () -> Unit,
    onAdd: (TodoItem) -> Unit,
    onUpdate: (TodoItem) -> Unit,
    onDelete: (Int) -> Unit
) {
    var title by remember { mutableStateOf(todo?.todo ?: "") }
    var completed by remember { mutableStateOf(todo?.completed ?: false) }
    val isEditMode = todo != null

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Completed")
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = completed,
                onCheckedChange = { completed = it }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (isEditMode) {
                    onUpdate(todo!!.copy(todo = title, completed = completed))
                } else {
                    onAdd(TodoItem(id = 0, todo = title, completed = completed, userId = 0))
                }
                onBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isEditMode) "Update Task" else "Add Task")
        }
        if (isEditMode) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    todo?.id?.let { onDelete(it) }
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Delete Task")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoDetailScreen() {
    TodoDetailScreen(
        todo = TodoItem(id = 1, todo = "Sample Task", completed = false, userId = 1),
        onBack = {},
        onAdd = {},
        onUpdate = {},
        onDelete = {}
    )
}
