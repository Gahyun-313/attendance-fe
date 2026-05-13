package com.example.attendance

import android.app.Application
import timber.log.Timber

/**
 * 앱의 Application 클래스
 */
class AttendanceApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Timber 초기화
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}