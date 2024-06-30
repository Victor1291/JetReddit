package com.shu.jetreddit

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

private const val argumentKey = "arg"

@Composable
fun MainNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    //viewModel: MainViewModel,
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = context.getString(AppRoute.Subreddits.route)
    ) {
        composable(context.getString(AppRoute.Subreddits.route)) {

        }
    }
}
