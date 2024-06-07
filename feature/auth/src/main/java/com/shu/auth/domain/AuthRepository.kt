package com.shu.auth.domain

import com.shu.models.ResponseToken

interface AuthRepository {

    suspend fun getToken(code: String): ResponseToken

}