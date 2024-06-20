package com.syafi.suitmediatest.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.syafi.suitmediatest.feature.chooseUser.ChooseUserScreen
import com.syafi.suitmediatest.feature.welcome.WelcomeScreen
import com.syafi.suitmediatest.feature.palindrome.PalindromeScreen
import com.syafi.suitmediatest.util.Route

@Composable
fun Navigation(navHostController: NavHostController, setOnNavigateUp: ((() -> Unit)?) -> Unit) {

    NavHost(navController = navHostController, startDestination = Route.PALINDROME_SCREEN) {
        composable(Route.PALINDROME_SCREEN) {
            PalindromeScreen(navHostController)
        }
        composable<Route.WELCOME_SCREEN> {
            val args = it.toRoute<Route.WELCOME_SCREEN>()

            WelcomeScreen(
                navController = navHostController,
                name = args.userName,
                selectedUserName = args.selectedUsername,
                setOnNavigateUp
            )
        }
        composable<Route.CHOOSE_USER_SCREEN> {

            val args= it.toRoute<Route.CHOOSE_USER_SCREEN>()


            ChooseUserScreen(navController = navHostController, userName = args.userName, setOnNavigateUp = setOnNavigateUp)
        }
    }
}