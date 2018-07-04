package com.ehailing.ehailing.data.local

import com.ehailing.ehailing.R
import com.ehailing.ehailing.data.StationModel
import com.github.debop.kodatimes.hours
import com.github.debop.kodatimes.minutes
import io.reactivex.Observable
import io.reactivex.Observable.just
import org.joda.time.DateTime

/**
 * Stub data
 */
class LocalSource {
    fun getStationStub(): Observable<MutableList<StationModel>> = just(mutableListOf<StationModel>().apply {
        add(StationModel(R.drawable.azriali, "Azrieli", DateTime.now() + 30.minutes()))
        add(StationModel(R.drawable.bima, "Habima", DateTime.now() + 30.minutes() ))
        add(StationModel(R.drawable.gordon, "Gordon", DateTime.now() + 32.minutes()))
        add(StationModel(R.drawable.shakem, "Shekem",DateTime.now() + 34.minutes() ))
        add(StationModel(R.drawable.stars, "Castle", DateTime.now() + 50.minutes()))
        add(StationModel(R.drawable.hadera, "Hadera", DateTime.now() + 2.hours() + 5.minutes()))
    })
}