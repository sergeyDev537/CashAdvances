package com.most4dev.cashadvances.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.most4dev.cashadvances.R
import com.most4dev.cashadvances.managers.ConnectionLoansManager
import com.most4dev.cashadvances.viewModels.StartViewModelLoans

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var startViewModelCashAdvance: StartViewModelLoans

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startViewModelCashAdvance = ViewModelProvider(this)[StartViewModelLoans::class.java]

        startViewModelCashAdvance.getListForecastCashAdvance()!!.observe(this) {
            if (ConnectionLoansManager.checkConnection(this)) {
                startTimerCashAdvance(it)
            } else {
                Toast.makeText(this, R.string.error_connection, Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun startTimerCashAdvance(code: String) {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                nextActionCashAdvance(code)
            }
        }.start()
    }

    private fun nextActionCashAdvance(codeCashAdvance: String) {
        val intentCashAdvance = Intent(this, MainActivity::class.java)
        intentCashAdvance.putExtra("codeRequest", codeCashAdvance)
        startActivity(intentCashAdvance)
        finish()
    }
}