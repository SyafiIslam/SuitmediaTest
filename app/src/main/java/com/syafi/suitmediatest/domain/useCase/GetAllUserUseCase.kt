package com.syafi.suitmediatest.domain.useCase

import com.syafi.suitmediatest.data.remote.response.UserDataResponse
import com.syafi.suitmediatest.data.repository.Repository
import com.syafi.suitmediatest.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllUserUseCase @Inject constructor(
    private val repo: Repository
) {

    suspend operator fun invoke(page: Int, perPage: Int): Flow<Resource<UserDataResponse>> =
        flow {
            emit(Resource.Loading())

            try {
                val response = repo.getAllUser(page, perPage)
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }
}