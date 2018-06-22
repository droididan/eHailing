package com.ehailing.ehailing.ui.taxis

 import android.arch.lifecycle.MutableLiveData
 import com.ehailing.ehailing.common.AbstractViewModel
 import com.ehailing.ehailing.data.StationModel
 import com.ehailing.ehailing.data.TaxiRepository
 import io.reactivex.Observable
 import java.util.concurrent.TimeUnit

class TaxiViewModel(private val repository: TaxiRepository) : AbstractViewModel() {

    val uiData = MutableLiveData<List<StationModel>>()

    fun getStations() {
        launch {
            Observable.interval(5, TimeUnit.SECONDS)
                    .flatMap { repository.getStations() }
                    .subscribe({ uiData.value = it },{})
        }
    }
}