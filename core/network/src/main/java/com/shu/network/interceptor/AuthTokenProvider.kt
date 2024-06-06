package com.shu.network.interceptor

import android.content.Context
import com.shu.network.TOKEN_SHARED_KEY
import com.shu.network.sharedprefsservice.SharedPrefsService

class AuthTokenProvider(private val context: Context,
                        private val sharedPrefsService: SharedPrefsService
) {

    fun getToken() = sharedPrefsService.create(context)
        .getString(TOKEN_SHARED_KEY, "")
}