package com.syafi.suitmediatest.data.repository

import com.syafi.suitmediatest.data.remote.api.ApiService
import com.syafi.suitmediatest.data.remote.response.UserDataResponse
import com.syafi.suitmediatest.domain.repository.IRepository

class Repository(
    private val api: ApiService
): IRepository {
    override fun checkPalindrome(text: String): Boolean {
        val reversedText= text.reversed().replace(" ", "")
        return reversedText == text.replace(" ", "")
    }

    override suspend fun getAllUser(page: Int, perPage: Int): UserDataResponse {
        val response= api.getAllUser(page, perPage)

        if (response.isSuccessful) {
            response.body()?.let {
                return it
            }
        }

        throw Exception(response.errorBody()?.string())
    }
}