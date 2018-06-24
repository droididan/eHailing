package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.ehailing.ehailing.R
import com.ehailing.ehailing.base.BaseFragment
import com.ehailing.ehailing.common.snackBar
import kotlinx.android.synthetic.main.taxi_fragment.*
import org.koin.android.architecture.ext.viewModel

class TaxiFragment : BaseFragment() {

    private val viewModel: TaxiViewModel by viewModel()
    private lateinit var adapter: TaxiAdapter

    override fun layoutId(): Int = R.layout.taxi_fragment

    companion object {
        fun newInstance() = TaxiFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        viewModel.getStations()
    }

    private fun initRecyclerView() {
        adapter = TaxiAdapter { snackBar(main, it.title) }
        recyclerView.adapter = adapter

    }

    override fun render() {
        viewModel.uiData.observe(this, Observer { adapter.stations = it ?: listOf() })
        viewModel.failure.observe(this, Observer { snackBar(main, getString(R.string.error_message)) })
    }
}