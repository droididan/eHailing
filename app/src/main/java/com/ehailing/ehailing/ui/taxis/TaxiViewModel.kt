package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.MutableLiveData
import com.ehailing.ehailing.common.AbstractViewModel
import com.ehailing.ehailing.common.SchedulerProvider
import com.ehailing.ehailing.common.with
import com.ehailing.ehailing.data.StationModel
import com.ehailing.ehailing.data.TaxiRepository
import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class TaxiViewModel(private val repository: TaxiRepository,
                    private val scheduler: SchedulerProvider) : AbstractViewModel() {

    // LiveData var to emit data to the UI
    val uiData = MutableLiveData<List<StationModel>>()

    fun getStations() {
        launch {
            // every 5 seconds send the data on the stream
            Observable.interval(0, 5, TimeUnit.SECONDS)
                    .with(scheduler)
                    .flatMap { repository.getStations() }
                    .map { changeETA(it) }
                    .map { it.sortedBy { it.arrivalTime } }
                    .subscribe({ uiData.value = it }, { handleFailure(it) })
        }
    }

    // Update all items with a new ETA
    private fun changeETA(station: MutableList<StationModel>) = station.map {
        StationModel(it.resource, it.title, it.arrivalTime)
    }
}