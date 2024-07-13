package com.task.jetpackcompose



import retrofit2.http.*

interface TodoApiService {
    @GET("todos") suspend fun getTodoList(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): TodoResponse

    @GET("todos/{id}")
    suspend fun getTodoItem(@Path("id") id: Int): TodoItem

    @POST("todos")
    suspend fun addTodoItem(@Body todoItem: TodoItem): TodoItem

    @PUT("todos/{id}")
    suspend fun updateTodoItem(@Path("id") id: Int, @Body todoItem: TodoItem): TodoItem

    @DELETE("todos/{id}")
    suspend fun deleteTodoItem(@Path("id") id: Int)
}
