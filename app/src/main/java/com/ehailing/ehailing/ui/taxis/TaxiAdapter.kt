package com.ehailing.ehailing.ui.taxis

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ehailing.ehailing.R
import com.ehailing.ehailing.common.inflate
import com.ehailing.ehailing.common.loadFromRes
import com.ehailing.ehailing.data.StationModel
import kotlinx.android.synthetic.main.station_item.view.*
import kotlin.properties.Delegates

class TaxiAdapter : RecyclerView.Adapter<TaxiAdapter.TaxiHolder>() {
    var stations : List<StationModel> by Delegates.observable(listOf()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaxiHolder = TaxiHolder(parent)
    override fun getItemCount(): Int = stations.size
    override fun onBindViewHolder(holder: TaxiHolder, position: Int) { holder.bind(stations[position]) }

    inner class TaxiHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.station_item)) {
        fun bind(station: StationModel) = with(itemView) {
            arrival.text = station.arrivalTime
            image.loadFromRes(station.resource)
            stationName.text = station.title
        }
    }
}