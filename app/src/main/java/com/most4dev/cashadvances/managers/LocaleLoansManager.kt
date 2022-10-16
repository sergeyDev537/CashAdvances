package com.most4dev.cashadvances.managers

import android.content.Context
import java.util.*
import android.telephony.TelephonyManager

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

        fun getLangKeyboardLocale(): String {
            return Locale.getDefault().language
        }
    }
}