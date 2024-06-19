package com.syafi.suitmediatest.domain.repository

import com.syafi.suitmediatest.data.remote.response.UserDataResponse

interface IRepository {

    fun checkPalindrome(text: String): Boolean
    suspend fun getAllUser(page: Int= 1, perPage: Int= 10): UserDataResponse
}