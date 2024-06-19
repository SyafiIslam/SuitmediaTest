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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.syafi.suitmediatest.feature.component.view.CustomButton
import com.syafi.suitmediatest.util.Route

@Composable
fun WelcomeScreen(navController: NavController, name: String, selectedUserName: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 60.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Welcome", fontSize = 14.sp)
        Text(text = name, fontSize = 22.sp, fontWeight = FontWeight(600))

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = selectedUserName, fontSize = 28.sp, fontWeight = FontWeight(600))
            CustomButton(
                onClick = { navController.navigate(Route.CHOOSE_USER_SCREEN(name)) },
                text = "Choose a user",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}