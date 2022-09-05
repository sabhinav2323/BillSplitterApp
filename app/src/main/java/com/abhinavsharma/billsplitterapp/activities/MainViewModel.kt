package com.abhinavsharma.billsplitterapp.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    var isLoading = _isLoading.asStateFlow()

    init{
        viewModelScope.launch{
            delay(1000)
            _isLoading.value = false
        }
    }
}