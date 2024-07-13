package com.task.jetpackcompose

import androidx.paging.PagingSource
import androidx.paging.PagingState

class TodoPagingSource(private val apiService: TodoApiService) : PagingSource<Int, TodoItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TodoItem> {
        return try {
            val currentPage = params.key ?: 0
            val response = apiService.getTodoList(params.loadSize, currentPage * params.loadSize)
            LoadResult.Page(
                data = response.todos,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (response.todos.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TodoItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

