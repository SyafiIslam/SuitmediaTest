package com.syafi.suitmediatest.data.remote.api

import com.syafi.suitmediatest.data.remote.response.UserDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getAllUser(
        @Query("page") page: Int= 1,
        @Query("per_page") perPage: Int= 10
    ): Response<UserDataResponse>
}