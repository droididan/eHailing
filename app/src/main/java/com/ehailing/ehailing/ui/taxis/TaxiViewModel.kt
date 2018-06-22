package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.MutableLiveData
import com.ehailing.ehailing.common.AbstractViewModel
import com.ehailing.ehailing.common.SchedulerProvider
import com.ehailing.ehailing.common.with
import com.ehailing.ehailing.data.StationModel
import com.ehailing.ehailing.data.TaxiRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class TaxiViewModel(private val repository: TaxiRepository,
                    private val scheduler: SchedulerProvider) : AbstractViewModel() {

     val uiData = MutableLiveData<List<StationModel>>()

    fun getStations() {
        launch {
            Observable.interval(5, TimeUnit.SECONDS)
                    .flatMap { repository.getStations() }
                    .with(scheduler)
                    .subscribe({ uiData.value = it }, { handleFailure(it) })
        }
    }
}