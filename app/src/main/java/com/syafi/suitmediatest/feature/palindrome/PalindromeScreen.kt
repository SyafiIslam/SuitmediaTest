package com.syafi.suitmediatest.feature.palindrome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.feature.palindrome.component.PalindromeForm

@Composable
fun PalindromeScreen(navController: NavController, viewModel: PalindromeViewModel= hiltViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = R.drawable.ic_profile,
            contentDescription = "profile",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray, CircleShape)
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        PalindromeForm(navController, viewModel)
    }
}