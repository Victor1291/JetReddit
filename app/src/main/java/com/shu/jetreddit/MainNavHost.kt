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

     /*   composable(context.getString(AppRoute.SearchScreen.route)) {

            BackHandler {
                navController.popBackStack()
            }
        }

        composable(context.getString(AppRoute.PersonScreen.route)) {

            BasketScreen()

            BackHandler {
                navController.popBackStack()
            }
        }
        composable(
            route = "${context.getString(AppRoute.DetailScreen.route)}/{$argumentKey}",
            arguments = listOf(navArgument(argumentKey) {
                type = ProductParametersType
            })
        ) { navBackStackEntry ->

            val arguments = navBackStackEntry.arguments
            val params = arguments?.getString(argumentKey)

            val paramsData = params?.let {
                ProductParametersType.parseValue(it)
            }
            DetailScreen(paramsData, navController, onProductClick = { product ->
                //save in Basket
                viewModel.addProduct(product)
            })

            BackHandler {
                navController.popBackStack()
            }
        }*/
    }
}
