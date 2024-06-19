package com.syafi.suitmediatest.feature.component.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(modifier: Modifier = Modifier, onClick: () -> Unit, text: String) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}