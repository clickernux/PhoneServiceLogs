package com.taureanx.phoneservicelogs

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class ServiceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceRepository.initialize(this)
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
    }
}