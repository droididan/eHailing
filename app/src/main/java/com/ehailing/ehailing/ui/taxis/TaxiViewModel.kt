package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.MutableLiveData
import com.ehailing.ehailing.common.*
import com.ehailing.ehailing.data.StationModel
import com.ehailing.ehailing.data.TaxiRepository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class TaxiViewModel(private val repository: TaxiRepository,
                    private val scheduler: SchedulerProvider) : AbstractViewModel() {

    // LiveData var to emit data to the UI
    val uiData = MutableLiveData<List<StationRender>>()

    fun getStations() = launch {
        // every 5 seconds send the data on the stream
        Observable.interval(0, 5, TimeUnit.SECONDS)
                .with(scheduler)
                .flatMap { repository.getStations() }
                .map { changeETA(it) }
                .map { it.sortedBy { it.arrivalTime } }
                .subscribe({ uiData.value = it }, { handleFailure(it) })
    }

    // Update all items with a new ETA
    private fun changeETA(station: MutableList<StationModel>) = station.map {
        val updateTime = it.arrivalTime?.plusMinutes(updateRandomETA())?.millis ?: 0
        StationRender(it.resource, it.title, updateTime)
    }
}