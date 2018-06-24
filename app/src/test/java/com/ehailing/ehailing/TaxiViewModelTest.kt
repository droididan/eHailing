package com.ehailing.ehailing

import android.arch.lifecycle.Observer
import com.ehailing.ehailing.data.StationModel
import com.ehailing.ehailing.data.TaxiRepository
import com.ehailing.ehailing.di.testApp
import com.ehailing.ehailing.ui.taxis.TaxiViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TaxiViewModelTest : KoinTest {
    val viewModel: TaxiViewModel by inject()
    val repository: TaxiRepository by inject()

    @Mock
    lateinit var uiData: Observer<List<StationModel>>

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        startKoin(testApp)
    }

    @After
    fun after() {
        closeKoin()
    }

    @Test
    fun getStations() {

        // Observe
        viewModel.uiData.observeForever(uiData)
        val stations = repository.getStations()



    }
}