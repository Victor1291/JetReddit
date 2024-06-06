package com.shu.jetreddit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.shu.jetreddit.ui.theme.JetRedditTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetRedditTheme {
                val navController = rememberNavController()
                //val viewModel: MainViewModel = hiltViewModel()
                val bottomNavigationItems = listOf(
                    AppRoute.Subreddits,
                    AppRoute.Favourites,
                    AppRoute.Profile,
                )
                Scaffold(
                    content = { MainNavHost(navController, it) },
                    bottomBar = {
                        BottomNav(navController, bottomNavigationItems)
                    }
                )
            }
        }
    }
}
