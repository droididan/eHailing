package com.ehailing.ehailing.data.local

import com.ehailing.ehailing.R
import com.ehailing.ehailing.data.StationModel
import io.reactivex.Observable

class LocalSource {
    fun getStationStub(): Observable<MutableList<StationModel>> =
            Observable.just(mutableListOf<StationModel>().apply {
                add(StationModel(R.drawable.azriali, "Azriali Taxi", "3m"))
                add(StationModel(R.drawable.bima, "Bima Taxi", "3m"))
                add(StationModel(R.drawable.gordon, "Gordon Taxi", "3m"))
                add(StationModel(R.drawable.shakem, "Shakam Taxi", "3m"))
                add(StationModel(R.drawable.stars, "Stars Taxi", "3m"))
            })
}