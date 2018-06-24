package com.ehailing.ehailing.di
import com.ehailing.ehailing.common.SchedulerProvider
import com.ehailing.ehailing.common.TestSchedulerProvider
import com.ehailing.ehailing.data.local.LocalSource
import org.koin.dsl.module.applicationContext


val localSource = applicationContext {
    bean { LocalSource() }
}
val testSchedulers = applicationContext {
    bean { TestSchedulerProvider() as SchedulerProvider }
}

val testApp = eHailApp  +  testSchedulers + localSource