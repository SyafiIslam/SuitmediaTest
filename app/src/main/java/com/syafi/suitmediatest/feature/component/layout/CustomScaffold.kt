package com.syafi.suitmediatest.feature.component.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CustomScaffold(
    isShowTopBar: Boolean = false,
    navController: NavController,
    appBarTitle: String,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { if (isShowTopBar) TopBar(navController = navController, title = appBarTitle) },
        content = content
    )
}