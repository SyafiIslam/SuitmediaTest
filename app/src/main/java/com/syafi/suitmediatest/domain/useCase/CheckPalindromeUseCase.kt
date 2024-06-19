package com.syafi.suitmediatest.domain.useCase

import com.syafi.suitmediatest.data.repository.Repository
import javax.inject.Inject

class CheckPalindromeUseCase @Inject constructor(
    private val repo: Repository
) {

    operator fun invoke(text: String)= repo.checkPalindrome(text)
}