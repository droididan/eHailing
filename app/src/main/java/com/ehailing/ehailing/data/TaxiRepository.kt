package com.ehailing.ehailing.data

import com.ehailing.ehailing.data.local.LocalSource
import io.reactivex.Observable

interface TaxiRepository {
    fun getStations() : Observable<MutableList<StationModel>>
}

class TaxiRepositoryImpl(private val local: LocalSource) : TaxiRepository {
    override fun getStations(): Observable<MutableList<StationModel>> =
            local.getStationStub()
}