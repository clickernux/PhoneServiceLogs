package com.taureanx.phoneservicelogs

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val serviceRepository = ServiceRepository.get()
    val services = serviceRepository.getServices()
}