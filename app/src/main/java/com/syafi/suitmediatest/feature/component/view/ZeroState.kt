package com.syafi.suitmediatest.feature.component.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.ui.theme.Neutral50
import com.syafi.suitmediatest.ui.theme.Type

@Composable
fun ZeroState(modifier: Modifier= Modifier) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(6.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Neutral50),
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = R.drawable.img_zero_state,
                contentDescription = "zero state",
                modifier = Modifier.size(140.dp)
            )
            Text(text = stringResource(R.string.the_list_is_empty), style = Type.textlgSemiBold())
        }
    }
}