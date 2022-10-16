package com.most4dev.cashadvances.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.most4dev.cashadvances.adapters.LanguageAdapter
import com.most4dev.cashadvances.managers.CustomDialogLoansManager
import com.most4dev.cashadvances.managers.LocaleLoansManager
import kotlinx.android.synthetic.main.dialog_language.*
import com.most4dev.cashadvances.R

class MainActivity : AppCompatActivity() {

    lateinit var navControllerCashAdvance: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_loans) as NavHostFragment
        navControllerCashAdvance = navHostFragment.navController

    }

    override fun onCreateOptionsMenu(menuCashAdvance: Menu?): Boolean {
        menuInflater.inflate(R.menu.language_menu, menuCashAdvance)
        setIconLanguageCashAdvance(
            this,
            LocaleLoansManager.loadLanguageLocale(this),
            menuCashAdvance!!.getItem(0)
        )
        return true
    }

    override fun onOptionsItemSelected(itemCashAdvance: MenuItem): Boolean {
        return when (itemCashAdvance.itemId) {
            R.id.language -> {
                createDialogLanguageCashAdvance(itemCashAdvance)
                true
            }
            else -> super.onOptionsItemSelected(itemCashAdvance)
        }
    }

    private fun createDialogLanguageCashAdvance(itemCashAdvance: MenuItem) {
        val dialogCashAdvance = CustomDialogLoansManager.createLanguageDialog(this)
        val listLangCashAdvance = CustomDialogLoansManager.createListLanguage(this)
        val adapterLanguageCashAdvance = LanguageAdapter(
            listLangCashAdvance
        )
        adapterLanguageCashAdvance.clickURLLanguage = { itLanguage ->
            LocaleLoansManager.setLocaleNewLocale(this, itLanguage.codeLanguage)
            LocaleLoansManager.saveLanguageLocale(this, itLanguage.codeLanguage)
            setIconLanguageCashAdvance(this, itLanguage.codeLanguage, itemCashAdvance)
            dialogCashAdvance.cancel()
            recreate()
        }

        dialogCashAdvance.recyclerViewLanguageLoans.layoutManager = LinearLayoutManager(this)
        dialogCashAdvance.recyclerViewLanguageLoans.adapter = adapterLanguageCashAdvance
        dialogCashAdvance.show()
    }

    private fun setIconLanguageCashAdvance(
        context: Context,
        codeLanguageCashAdvance: String,
        itemCashAdvance: MenuItem
    ) {
        if (codeLanguageCashAdvance.lowercase() == "ru") {
            itemCashAdvance.icon = ContextCompat.getDrawable(context, R.drawable.ic_ru_flag_loans)
        } else if (codeLanguageCashAdvance.lowercase() == "es" ||
            codeLanguageCashAdvance.lowercase() == "sp"
        ) {
            itemCashAdvance.icon = ContextCompat.getDrawable(context, R.drawable.ic_es_flag_loans)
        } else {
            itemCashAdvance.icon = ContextCompat.getDrawable(context, R.drawable.ic_us_flag_loans)
        }
    }

}