package com.ehailing.ehailing

import android.app.Application
import com.ehailing.ehailing.di.eHailApp
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, eHailApp)

    }
}