package com.syafi.suitmediatest.data.remote.response

data class UserDataResponse(
    val `data`: List<UserData>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)