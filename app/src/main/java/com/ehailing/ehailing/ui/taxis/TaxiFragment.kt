package com.ehailing.ehailing.ui.taxis

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.ehailing.ehailing.R
import com.ehailing.ehailing.base.BaseFragment

class TaxiFragment : BaseFragment() {
    private lateinit var viewModel: TaxiViewModel

    override fun layoutId(): Int = R.layout.taxi_fragment

    companion object {
        fun newInstance() = TaxiFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaxiViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
