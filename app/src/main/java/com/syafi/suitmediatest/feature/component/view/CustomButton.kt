package com.syafi.suitmediatest.feature.component.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.syafi.suitmediatest.ui.theme.Primary
import com.syafi.suitmediatest.ui.theme.Type

@Composable
fun CustomButton(modifier: Modifier = Modifier, onClick: () -> Unit, text: String, color: Color= Primary) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            style = Type.textsmBold()
        )
    }
}