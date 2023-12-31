package com.asterekhin.secretchat2.presentation.registration.viewModel

sealed class RegistrationState {
    data class Success(val isRegistered: Boolean): RegistrationState()
    data class Error(val message: String): RegistrationState()
    object Loading: RegistrationState()
    object Empty: RegistrationState()

}
