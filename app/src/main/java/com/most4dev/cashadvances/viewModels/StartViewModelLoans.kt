package com.most4dev.cashadvances.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.most4dev.cashadvances.background.GetStartKey

class StartViewModelLoans(application: Application) : AndroidViewModel(application) {

    private var dataForecastCashAdvance: MutableLiveData<String>? = null

    fun getListForecastCashAdvance():
            LiveData<String>? {
        if (dataForecastCashAdvance == null) {
            dataForecastCashAdvance = MutableLiveData()
            val asyncIntCashAdvance =
                GetStartKey(
                    getApplication(),
                    dataForecastCashAdvance
                )
            asyncIntCashAdvance.execute(mutableMapOf<String, String>())
        }
        return dataForecastCashAdvance
    }

}