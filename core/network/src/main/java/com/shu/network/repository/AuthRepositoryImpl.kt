package com.shu.network.repository

import com.shu.auth.domain.AuthRepository
import com.shu.models.ResponseToken
import com.shu.network.ApiToken

class AuthRepositoryImpl(
    private val apiToken: ApiToken,
): AuthRepository {
    override suspend fun getToken(code: String): ResponseToken {
        return apiToken.getToken(code = code)
    }


}