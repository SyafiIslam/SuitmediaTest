package com.syafi.suitmediatest.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.syafi.suitmediatest.feature.component.layout.CustomScaffold
import com.syafi.suitmediatest.feature.navigation.Navigation
import com.syafi.suitmediatest.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val showTopBarList = listOf(
        Route.WELCOME_ROUTE,
        Route.CHOOSE_USER_ROUTE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val (onNavigateUp, setOnNavigateUp) = remember {
                mutableStateOf<(() -> Unit)?>(null)
            }

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            CustomScaffold(
                navController = navController,
                isShowTopBar = checkRoute(currentRoute.toString(), showTopBarList),
                appBarTitle = getRouteName(currentRoute.toString()),
                onNavigateUp= { onNavigateUp?.let { it() } }
            ) {
                Navigation(navHostController = navController, setOnNavigateUp)
            }
        }
    }

    private fun checkRoute(currentRoute: String, screenList: List<String>) =
        screenList.any { currentRoute.contains(it) }

    private fun getRouteName(currentRoute: String): String {
        return when {
            currentRoute.contains(Route.WELCOME_ROUTE) -> "Welcome Screen"
            currentRoute.contains(Route.CHOOSE_USER_ROUTE) -> "Choose User Screen"
            else -> "Unknown Route"
        }
    }
}