package com.syafi.suitmediatest.feature.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.suitmediatest.ui.theme.Neutral50
import com.syafi.suitmediatest.ui.theme.Type

@Composable
fun TopBar(navController: NavController, title: String, onNavigateUp: () -> Unit?) {
    Row(
        Modifier
            .background(Neutral50)
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(onClick = { onNavigateUp() }, Modifier.size(20.dp)) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = title)
        }
        Text(text = title, style = Type.textlgSemiBold())
    }
}