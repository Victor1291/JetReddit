package com.shu.jetreddit

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(@StringRes val route: Int, @StringRes val label: Int, val icon: ImageVector) {

    data object OnBoarding : AppRoute(
        route = R.string.navigation_on_boarding,
        label = R.string.onBoarding,
        icon = Icons.Default.Home
    )

    data object Auth : AppRoute(
        route = R.string.navigation_auth,
        label = R.string.auth,
        icon = Icons.Default.Search
    )

    data object Subreddits : AppRoute(
        route = R.string.navigation_home,
        label = R.string.subreddits,
        icon = Icons.Default.ShoppingCart
    )

    data object Favourites : AppRoute(
        route = R.string.navigation_favourites,
        label = R.string.favourites,
        icon = Icons.Default.Menu
    )

    data object Profile : AppRoute(
        route = R.string.navigation_profile,
        label = R.string.profile,
        icon = Icons.Default.Menu
    )

    data object Friends : AppRoute(
        route = R.string.navigation_friends,
        label = R.string.friends,
        icon = Icons.Default.Menu
    )

    data object SingleSubreddit : AppRoute(
        route = R.string.navigation_single_subreddit,
        label = R.string.single_subreddit,
        icon = Icons.Default.Menu
    )

    data object User : AppRoute(
        route = R.string.navigation_user,
        label = R.string.user,
        icon = Icons.Default.Menu
    )

    data object Comments : AppRoute(
        route = R.string.navigation_comments,
        label = R.string.comments,
        icon = Icons.Default.Menu
    )

}