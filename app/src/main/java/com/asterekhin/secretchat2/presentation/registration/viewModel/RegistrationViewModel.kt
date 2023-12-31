package com.asterekhin.secretchat2.presentation.registration.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asterekhin.secretchat2.domain.repository.ChatRepository
import com.asterekhin.secretchat2.presentation.chatList.viewModel.ChatListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val repository: ChatRepository,
): ViewModel(){

    private val _registrationSate = MutableStateFlow<RegistrationState>(RegistrationState.Empty)
    val registrationSate = _registrationSate.asStateFlow()

    private fun createUser(userName: String) {
        _registrationSate.value = RegistrationState.Loading
        if (!checkToValidName(userName)) return

        viewModelScope.launch {
            val result = repository.createUser(userName)
            _registrationSate.value = RegistrationState.Success(result)
        }
    }

    private fun checkToValidName(userName: String): Boolean {
        if (userName.contains("\n") || userName.contains("\r")) {
            _registrationSate.value = RegistrationState.Error("No allowed '\n' symbol")
            return false
        }

        if (userName.length < 3) {
            _registrationSate.value = RegistrationState.Error("No allowed name less than 3")
            return false
        }

        if (userName.length >= 10) {
            _registrationSate.value = RegistrationState.Error("No allowed name grater than 10")
            return false
        }

        return true
    }
}