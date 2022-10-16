package com.most4dev.cashadvances.managers

import android.app.Dialog
import android.content.Context
import com.most4dev.cashadvances.R
import com.most4dev.cashadvances.model.ModelLanguageLoans

class CustomDialogLoansManager {

    companion object {

        fun createLanguageDialog(context: Context): Dialog {

            val dialog = Dialog(
                context,
                android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen
            )
            dialog.setContentView(R.layout.dialog_language)
            return dialog
        }

        fun createListLanguage(context: Context): ArrayList<ModelLanguageLoans> {
            val listLanguage = ArrayList<ModelLanguageLoans>()
            listLanguage.add(
                ModelLanguageLoans(
                    context.getString(R.string.english),
                    context.getString(R.string.gb)
                )
            )
            listLanguage.add(
                ModelLanguageLoans(
                    context.getString(R.string.russian),
                    context.getString(R.string.ru)
                )
            )
            listLanguage.add(
                ModelLanguageLoans(
                    context.getString(R.string.spanish),
                    context.getString(R.string.sp)
                )
            )
            return listLanguage
        }
    }

}