package com.ehailing.ehailing.ui.taxis

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ehailing.ehailing.R
import com.ehailing.ehailing.common.formatPretty
import com.ehailing.ehailing.common.inflate
import com.ehailing.ehailing.common.loadFromRes
import kotlinx.android.synthetic.main.station_item.view.*
import kotlin.properties.Delegates


class TaxiAdapter(val click: (StationRender) -> Unit) : RecyclerView.Adapter<TaxiAdapter.TaxiHolder>() {

    // observe changes on the data model
    var stations: List<StationRender> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = stations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaxiHolder = TaxiHolder(parent)

    override fun onBindViewHolder(holder: TaxiHolder, position: Int) {
        holder.bind(stations[position])
    }

    inner class TaxiHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.station_item)) {

        fun bind(station: StationRender) = with(itemView) {
            setOnClickListener { click.invoke(station) }
            arrival.text = station.arrivalTime?.formatPretty()
            image.loadFromRes(station.resource)
            stationName.text = station.title
        }
    }
}