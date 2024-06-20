package com.syafi.suitmediatest.feature.chooseUser

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.syafi.suitmediatest.R
import com.syafi.suitmediatest.feature.chooseUser.component.UserDataCard
import com.syafi.suitmediatest.feature.component.view.CustomLazyColumn
import com.syafi.suitmediatest.feature.component.view.Loading
import com.syafi.suitmediatest.feature.component.view.ZeroState
import com.syafi.suitmediatest.util.Resource
import com.syafi.suitmediatest.util.Route
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ChooseUserScreen(
    navController: NavController,
    viewModel: ChooseUserViewModel = hiltViewModel(),
    userName: String,
    setOnNavigateUp: (() -> Unit) -> Unit,
) {

    val isRefreshing by viewModel.isRefreshing
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val usersList = viewModel.userDataPager.collectAsLazyPagingItems()

    setOnNavigateUp {
        navController.popBackStack()
    }


    LaunchedEffect(key1 = true) {
        getAllUser(viewModel, this, context)
    }

    if (viewModel.isLoading.value) {
        Loading()
    }

    Box(Modifier.fillMaxSize()) {
        if (usersList.itemCount == 0) {
            ZeroState(Modifier.padding(top = 60.dp).fillMaxWidth())
        } else {
            CustomLazyColumn(
                items = usersList,
                content = {
                    UserDataCard(
                        userData = it,
                        onCardClick = {
                            navController.navigate(
                                Route.WELCOME_SCREEN(
                                    userName, selectedUsername =
                                    context.getString(
                                        R.string.selected_name,
                                        it.first_name,
                                        it.last_name
                                    )
                                )
                            )
                        }
                    )
                },
                isRefreshing = isRefreshing,
                onRefreshing = {
                    scope.launch {
                        viewModel.setRefreshingState(true)
                        getAllUser(viewModel, this, context)
                        delay(500)
                        viewModel.setRefreshingState(false)
                    }
                },
                modifier = Modifier.padding(top = 60.dp, start = 20.dp, end = 20.dp)
            )
        }
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun getAllUser(viewModel: ChooseUserViewModel, coroutineScope: CoroutineScope, context: Context) {
    coroutineScope.launch {
        viewModel.getAllUser(perPage = 10).collect {
            when (it) {
                is Resource.Error -> {
                    viewModel.setLoadingState(false)
                    showToast(context, it.message.toString())
                }

                is Resource.Loading -> viewModel.setLoadingState(true)
                is Resource.Success -> {
                    viewModel.setLoadingState(false)
                    viewModel.setRefreshingState(false)
                }
            }
        }
    }
}