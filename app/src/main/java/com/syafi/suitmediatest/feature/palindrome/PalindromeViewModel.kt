package com.syafi.suitmediatest.feature.palindrome

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.syafi.suitmediatest.domain.useCase.CheckPalindromeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PalindromeViewModel @Inject constructor(
    private val checkPalindromeUseCase: CheckPalindromeUseCase
) : ViewModel() {

    private val _name= mutableStateOf("")
    val name: State<String> = _name

    private val _palindrome= mutableStateOf("")
    val palindrome: State<String> = _palindrome

    fun setName(name: String) {
        _name.value= name
    }

    fun setPalindrome(palindrome: String) {
        _palindrome.value= palindrome
    }

    fun checkPalindrome(text: String)= checkPalindromeUseCase(text.trim())
}