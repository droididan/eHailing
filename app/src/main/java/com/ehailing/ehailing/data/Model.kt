package com.ehailing.ehailing.data

import org.joda.time.DateTime


// model represents a taxi station
data class StationModel(val resource: Int,
                        val title: String,
                        var arrivalTime: DateTime? = null)