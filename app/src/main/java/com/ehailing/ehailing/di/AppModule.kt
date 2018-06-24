package com.ehailing.ehailing.di

import com.ehailing.ehailing.common.ApplicationSchedulerProvider
import com.ehailing.ehailing.common.SchedulerProvider
import com.ehailing.ehailing.data.TaxiRepository
import com.ehailing.ehailing.data.TaxiRepositoryImpl
import com.ehailing.ehailing.data.local.LocalSource
import com.ehailing.ehailing.ui.taxis.TaxiAdapter
import com.ehailing.ehailing.ui.taxis.TaxiViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {
    // Taxis Module
    viewModel { TaxiViewModel(get(), get()) }
    bean { TaxiRepositoryImpl(get()) as TaxiRepository }
    bean { LocalSource() }
}

val rxModule = applicationContext {
    bean { ApplicationSchedulerProvider() as SchedulerProvider }
}

val eHailApp = listOf(appModule, rxModule)