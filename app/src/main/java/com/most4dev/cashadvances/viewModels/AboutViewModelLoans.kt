package com.most4dev.cashadvances.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.most4dev.cashadvances.background.GetAboutTheme
import com.most4dev.cashadvances.model.ThemeModelLoans

class AboutViewModelLoans(application: Application): AndroidViewModel(application) {

    private var dataThemeLoans: MutableLiveData<List<ThemeModelLoans>>? = null

    fun getListThemeLoans():
            LiveData<List<ThemeModelLoans>>? {
        if (dataThemeLoans == null) {
            dataThemeLoans = MutableLiveData()
            val asyncIntLoans =
                GetAboutTheme(
                    getApplication(),
                    dataThemeLoans
                )
            asyncIntLoans.execute(mutableMapOf<String, String>())
        }
        return dataThemeLoans
    }

}