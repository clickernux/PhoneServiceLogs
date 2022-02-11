package com.taureanx.phoneservicelogs

import android.app.Application

class ServiceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceRepository.initialize(this)
    }
}