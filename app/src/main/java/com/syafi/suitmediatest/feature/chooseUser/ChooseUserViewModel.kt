package com.syafi.suitmediatest.feature.chooseUser

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.syafi.suitmediatest.data.paging.UserPagingSource
import com.syafi.suitmediatest.data.repository.Repository
import com.syafi.suitmediatest.domain.useCase.GetAllUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseUserViewModel @Inject constructor(
    private val getAllUserUseCase: GetAllUserUseCase,
    private val repo: Repository
): ViewModel() {

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isRefreshing= mutableStateOf(false)
    val isRefreshing: State<Boolean> = _isRefreshing


    val userDataPager= Pager(
        PagingConfig(pageSize = 10)
    ) {
        UserPagingSource(repo)
    }.flow.cachedIn(viewModelScope)

    fun setLoadingState(state: Boolean) {
        _isLoading.value= state
    }

    fun setRefreshingState(state: Boolean) {
        _isRefreshing.value= state
    }

    suspend fun getAllUser(page: Int= 1, perPage: Int= 10) =
        getAllUserUseCase(page, perPage)
}