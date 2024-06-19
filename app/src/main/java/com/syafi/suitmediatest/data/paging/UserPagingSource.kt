package com.syafi.suitmediatest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.syafi.suitmediatest.data.remote.response.UserData
import com.syafi.suitmediatest.data.repository.Repository

class UserPagingSource(
    private val repo: Repository
): PagingSource<Int, UserData>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, UserData>): Int? {
        return state.anchorPosition?.let { position ->
            val page= state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserData> {
        return try {
            val position = params.key ?: 1
            val response = repo.getAllUser(page = position)
            val responseData= response.data
            LoadResult.Page(
                data = responseData,
                prevKey = null,
                nextKey = if (responseData.isNotEmpty()) response.page + 1 else null
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}