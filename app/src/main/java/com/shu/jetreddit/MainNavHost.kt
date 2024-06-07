package com.shu.jetreddit

import android.content.Intent
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.shu.auth.CheckState

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
        startDestination = context.getString(AppRoute.Auth.route)
    ) {
        composable(context.getString(AppRoute.Subreddits.route)) {
            Log.d("check navigation code", " start subreddits")
        }

        composable(context.getString(AppRoute.Auth.route)) {
            CheckState()
        }

        composable(
            "profile_login",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://humblrjet/redirect?state=my_state&amp;code={code}"
                    action = Intent.ACTION_VIEW
                }),
            arguments = listOf(
                navArgument("code") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(argumentKey)?.let { code ->
                Log.d("check code", " code =  $code")
                navController.navigate(
                    route = context.getString(AppRoute.Subreddits.route)
                )

            }
            BackHandler {
                navController.popBackStack()
            }
            // Profile(navController, backStackEntry.arguments?.getString("id"))
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
