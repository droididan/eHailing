package com.ehailing.ehailing.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ehailing.ehailing.R
import com.ehailing.ehailing.ui.taxis.TaxiFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TaxiFragment.newInstance())
                    .commitNow()
        }
    }

}
