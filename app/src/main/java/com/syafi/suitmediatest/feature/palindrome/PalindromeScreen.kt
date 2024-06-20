package com.syafi.suitmediatest.feature.palindrome

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.feature.palindrome.component.PalindromeForm
import com.syafi.suitmediatest.ui.theme.Neutral200
import com.syafi.suitmediatest.ui.theme.Neutral50
import com.syafi.suitmediatest.ui.theme.Primary
import com.syafi.suitmediatest.ui.theme.Type

@Composable
fun PalindromeScreen(
    navController: NavController,
    viewModel: PalindromeViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        AsyncImage(
            model = R.drawable.img_buble,
            contentDescription = "",
            modifier = Modifier
                .sizeIn(maxWidth = 160.dp, maxHeight = 160.dp)
                .align(Alignment.TopEnd)
        )

        Column {
            Text(
                text = stringResource(R.string.check_palindrome),
                color = Neutral50,
                style = Type.displayxsBold(),
                modifier = Modifier.padding(top = 40.dp, start = 20.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))

            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        Neutral50,
                        RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(horizontal = 20.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    model = R.drawable.profile,
                    contentScale = ContentScale.Crop,
                    contentDescription = "",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .border(width = 4.dp, color = Color.LightGray, shape = CircleShape)
                )
                Spacer(modifier = Modifier.height(40.dp))

                PalindromeForm(navController, viewModel)
            }
        }
    }
}