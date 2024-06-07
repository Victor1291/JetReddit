package com.shu.auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shu.auth.domain.AuthRepository
import com.shu.auth.domain.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed interface UiState {
    data object Success : UiState
    data class Error(var message: String = "") : UiState
    data object Loading : UiState
    data object NotStartedYet : UiState
}
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val storageService: StorageService
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.NotStartedYet)
    val state = _state.asStateFlow()

    fun createToken(code: String) {
        if (code != PLUG)
            viewModelScope.launch(Dispatchers.IO) {
                _state.value = UiState.Loading
                try {
                    storageService.saveEncryptedToken(
                        authRepository.getToken(code = code).access_token
                    )
                    _state.value = UiState.Success
                } catch (e: Exception) {
                    _state.value = UiState.Error(message = e.message.toString())
                }
            }
    }

    companion object {
        const val PLUG = ""
    }
}