package com.syafi.suitmediatest.feature.component.view

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import com.syafi.suitmediatest.ui.theme.Primary

@Composable
fun Loading() {
    Dialog(onDismissRequest = {  }) {
        CircularProgressIndicator(color = Primary)
    }
}