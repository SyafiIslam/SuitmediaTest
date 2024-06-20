package com.syafi.suitmediatest.feature.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.feature.component.view.CustomButton
import com.syafi.suitmediatest.ui.theme.Primary
import com.syafi.suitmediatest.ui.theme.Type
import com.syafi.suitmediatest.util.Route

@Composable
fun WelcomeScreen(
    navController: NavController,
    name: String,
    selectedUserName: String,
    setOnNavigateUp: (() -> Unit) -> Unit,
) {

    setOnNavigateUp {
        navController.popBackStack()
        navController.navigate(Route.PALINDROME_SCREEN)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(text = stringResource(R.string.welcome), style = Type.textsmRegular())
        Text(text = name, style = Type.textxlBold())

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = selectedUserName, style = Type.displayxsBold())
            CustomButton(
                onClick = { navController.navigate(Route.CHOOSE_USER_SCREEN(name)) },
                text = stringResource(R.string.choose_a_user),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .align(Alignment.BottomCenter),
                color = Primary
            )
        }
    }
}