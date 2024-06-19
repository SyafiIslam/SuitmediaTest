package com.syafi.suitmediatest.feature.component.view

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable
fun Loading() {
    Dialog(onDismissRequest = {  }) {
        CircularProgressIndicator()
    }
}