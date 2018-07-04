package com.ehailing.ehailing.data

import com.ehailing.ehailing.data.local.LocalSource
import io.reactivex.Observable

/**
 * TaxiRepository to get the taxi stations (as for now from a local data source only)
 */
interface TaxiRepository {
    fun getStations() : Observable<MutableList<StationModel>>
}

class TaxiRepositoryImpl(private val local: LocalSource) : TaxiRepository {
    override fun getStations(): Observable<MutableList<StationModel>> =
            local.getStationStub()
}