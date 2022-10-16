package com.most4dev.cashadvances.managers

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

class URLLoansManager {

    companion object{

        fun openURLEmbeddedBrowserLoans(contextLoans: Context, urlLoans: String){
            val builderLoans = CustomTabsIntent.Builder()
            val customTabsIntentLoans = builderLoans.build()
            customTabsIntentLoans.launchUrl(contextLoans, Uri.parse(urlLoans))
        }

    }

}