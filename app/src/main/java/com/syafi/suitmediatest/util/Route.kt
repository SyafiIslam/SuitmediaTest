package com.syafi.suitmediatest.util

import kotlinx.serialization.Serializable

object Route {
    const val PALINDROME_SCREEN= "palindrome_screen"
    const val WELCOME_ROUTE= "WELCOME_SCREEN"
    const val CHOOSE_USER_ROUTE= "CHOOSE_USER_SCREEN"

    @Serializable
    data class WELCOME_SCREEN(
        val userName: String,
        val selectedUsername: String= "Selected User Name"
    )

    @Serializable
    data class CHOOSE_USER_SCREEN(
        val userName: String,
    )
}