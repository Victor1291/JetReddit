package com.shu.auth

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.shu.auth.state.ErrorScreen
import com.shu.auth.state.LoadingScreen
import com.shu.auth.ui.AuthScreen
import com.shu.auth.ui.AuthScreenLogin
import com.shu.auth.ui.AuthViewModel
import com.shu.auth.ui.UiState
import com.shu.models.CALL


@Composable
fun CheckState(
    viewModel: AuthViewModel = hiltViewModel(),
) {
    val viewState by viewModel.state.collectAsState()
    val mContext = LocalContext.current

    when (viewState) {
        is UiState.Loading -> LoadingScreen()
        is UiState.Success -> {
            AuthScreenLogin()
            Log.d("auth_state","Success , go on Subredits")
        }
        is UiState.Error -> ErrorScreen(
            retryAction = { },
        )

        is UiState.NotStartedYet -> {
            AuthScreen(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CALL))
                    mContext.startActivity(intent)
                }
            )
        }
    }
}
