package com.ehailing.ehailing.ui.taxis

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ehailing.ehailing.data.StationModel

class TaxiAdapter : RecyclerView.Adapter<TaxiAdapter.TaxiHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: TaxiAdapter.TaxiHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class TaxiHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent) {
        fun bind(station: StationModel) {

        }
    }
}