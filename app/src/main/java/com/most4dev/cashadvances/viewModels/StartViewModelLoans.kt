package com.most4dev.cashadvances.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StartViewModelLoans(application: Application) : AndroidViewModel(application) {

    private var dataForecastCashAdvance: MutableLiveData<String>? = null

    fun getListForecastCashAdvance():
            LiveData<String>? {
        if (dataForecastCashAdvance == null) {
            dataForecastCashAdvance = MutableLiveData()
            //TODO background files
        }
        return dataForecastCashAdvance
    }

}