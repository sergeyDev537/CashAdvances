package com.most4dev.cashadvances.managers

import android.content.Context
import java.util.*
import android.telephony.TelephonyManager
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import androidx.preference.PreferenceManager

class LocaleLoansManager {

    companion object {

        fun getCountryLocale(): String {
            return Locale.getDefault().country
        }

        fun getSimCodeLocale(contextLocale: Context): String {
            val telephonyManager =
                contextLocale.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
            return telephonyManager!!.simOperatorName
        }

        fun setLocaleNewLocale(contextLoans: Context, languageCodeLoans: String?) {
            val localeLoans = languageCodeLoans?.let { Locale(it) }
            localeLoans?.let { Locale.setDefault(it) }
            val resourcesLoans: Resources = contextLoans.resources
            val configurationLoans: Configuration = resourcesLoans.configuration
            configurationLoans.setLocale(localeLoans)
            resourcesLoans.updateConfiguration(configurationLoans, resourcesLoans.displayMetrics)
        }

        fun saveLanguageLocale(contextLoans: Context, firebaseIDLoans: String) {
            val mSharedPreferencesLoans: SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(contextLoans)
            val mEditorLoans: SharedPreferences.Editor = mSharedPreferencesLoans.edit()
            mEditorLoans.putString("${contextLoans.packageName}/language", firebaseIDLoans).apply()
        }

        fun loadLanguageLocale(contextLoans: Context): String {
            val mSharedPreferencesLoans: SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(contextLoans)
            return mSharedPreferencesLoans.getString("${contextLoans.packageName}/language", "us")!!
        }

        fun getLangKeyboardLocale(): String {
            return Locale.getDefault().language
        }
    }
}