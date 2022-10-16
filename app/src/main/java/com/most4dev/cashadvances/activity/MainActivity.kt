package com.most4dev.cashadvances.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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
}