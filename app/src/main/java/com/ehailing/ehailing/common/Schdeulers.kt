package com.ehailing.ehailing.common

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Use SchedulerProvider configuration for Single
 */
fun <T> Observable<T>.with(schedulerProvider: SchedulerProvider): Observable<T> = observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

fun Completable.with(schedulerProvider: SchedulerProvider): Completable = observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

class ApplicationSchedulerProvider : SchedulerProvider {
    override fun io() = Schedulers.io()
    override fun ui() = AndroidSchedulers.mainThread()
    override fun computation() = Schedulers.computation()
}

interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
    fun computation(): Scheduler
}