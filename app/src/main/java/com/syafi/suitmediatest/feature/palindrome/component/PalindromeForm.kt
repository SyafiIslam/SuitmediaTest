package com.syafi.suitmediatest.feature.palindrome.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.suitmediatest.feature.component.view.CustomButton
import com.syafi.suitmediatest.feature.component.view.CustomTextField
import com.syafi.suitmediatest.feature.palindrome.PalindromeViewModel
import com.syafi.suitmediatest.util.Route

@Composable
fun PalindromeForm(navController: NavController, viewModel: PalindromeViewModel) {

    val context = LocalContext.current

    Column(Modifier.fillMaxWidth()) {
        CustomTextField(
            text = viewModel.name.value,
            onValueChange = {
                viewModel.setName(it)
            },
            label = "Name",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            text = viewModel.palindrome.value,
            onValueChange = {
                viewModel.setPalindrome(it)
            },
            label = "Palindrome",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(
            onClick = {
                if (viewModel.palindrome.value.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        if (viewModel.checkPalindrome(viewModel.palindrome.value.lowercase())) "isPalindrome"
                        else "notPalindrome",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(context, "Fill the palindrome text", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Check",
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            onClick = {
                if (viewModel.name.value.isNotEmpty()) {
                    navController.navigate(Route.WELCOME_SCREEN(userName = viewModel.name.value.trim()))
                } else {
                    Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                }
            },
            text = "Next",
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}