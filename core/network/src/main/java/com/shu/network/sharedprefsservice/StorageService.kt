package com.shu.network.sharedprefsservice

interface StorageService {
    fun saveEncryptedToken(data: String)
    fun save(key: String, data: Any?)
    fun load(key: String): Boolean
}