package com.syafi.suitmediatest.feature.chooseUser.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.syafi.suitmediatest.data.remote.response.UserData

@Composable
fun UserDataCard(userData: UserData, onCardClick: () -> Unit = {}) {
    Card(
        onClick = onCardClick,
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(6.dp),
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = userData.avatar,
                contentDescription = userData.last_name,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(5.dp))
                )

            Column(Modifier.weight(1f)) {
                Text(
                    text = "${userData.first_name} ${userData.last_name}",
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp
                )
                Text(text = userData.email, fontSize = 14.sp)
            }
        }
    }
}