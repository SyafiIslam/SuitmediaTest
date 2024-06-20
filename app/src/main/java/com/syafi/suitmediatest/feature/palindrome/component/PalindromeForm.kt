package com.syafi.suitmediatest.feature.palindrome.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.feature.component.view.CustomButton
import com.syafi.suitmediatest.feature.component.view.CustomTextField
import com.syafi.suitmediatest.feature.palindrome.PalindromeViewModel
import com.syafi.suitmediatest.ui.theme.Secondary
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
            label = stringResource(R.string.name),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            text = viewModel.palindrome.value,
            onValueChange = {
                viewModel.setPalindrome(it)
            },
            label = stringResource(R.string.palindrome),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))
        CustomButton(
            onClick = {
                if (viewModel.palindrome.value.isNotEmpty()) {
                    Toast.makeText(
                        context,
                        if (viewModel.checkPalindrome(viewModel.palindrome.value.lowercase())) context.getString(
                            R.string.ispalindrome
                        )
                        else context.getString(R.string.notpalindrome),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(context,
                        context.getString(R.string.fill_the_palindrome_text), Toast.LENGTH_SHORT).show()
                }
            },
            text = stringResource(R.string.check),
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
                    Toast.makeText(context,
                        context.getString(R.string.name_cannot_be_empty), Toast.LENGTH_SHORT).show()
                }
            },
            text = stringResource(R.string.next),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            color = Secondary
        )
    }
}