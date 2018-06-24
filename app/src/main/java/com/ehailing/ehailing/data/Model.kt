package com.ehailing.ehailing.data

import org.joda.time.DateTime



data class StationModel(val resource: Int,
                        val title: String,
                        var arrivalTime: DateTime? = null)

