package com.most4dev.cashadvances.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.most4dev.cashadvances.R
import kotlinx.android.synthetic.main.fragment_loan_calculator.*

class LoanCalculatorFragment : Fragment() {

    override fun onCreateView(
        inflaterLoanCalc: LayoutInflater,
        containerLoanCalc: ViewGroup?,
        savedInstanceStateLoanCalc: Bundle?
    ): View? {
        return inflaterLoanCalc.inflate(
            R.layout.fragment_loan_calculator,
            containerLoanCalc,
            false
        )
    }

    override fun onViewCreated(viewLoanCalc: View, savedInstanceStateLoanCalc: Bundle?) {
        super.onViewCreated(viewLoanCalc, savedInstanceStateLoanCalc)
        setChangeListenerLoanCalc()
    }

    private fun setChangeListenerLoanCalc() {
        editTextLoanAmountLoans.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculateLoanCalc()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        editTextLoanTermLoans.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculateLoanCalc()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        editTextInterestRateLoans.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                calculateLoanCalc()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

    }

    private fun calculateLoanCalc() {
        val loanAmountLoanCalc = checkEmptyLoanCalc(editTextLoanAmountLoans)
        val loanTermLoanCalc = checkEmptyLoanCalc(editTextLoanTermLoans)
        val interestRateLoanCalc = checkEmptyLoanCalc(editTextInterestRateLoans)

        val totalInterestLoanCalc = loanAmountLoanCalc*interestRateLoanCalc/100/31*loanTermLoanCalc
        val totalPaymentsLoanCalc = loanAmountLoanCalc+totalInterestLoanCalc
        val paymentEveryMonthLoanCalc = totalPaymentsLoanCalc/loanTermLoanCalc

        editTextPaymentEveryMonthLoans.text = paymentEveryMonthLoanCalc.toString()
        editTextTotalPaymentsLoans.text = totalPaymentsLoanCalc.toString()
        editTextTotalInterestLoans.text = totalInterestLoanCalc.toString()

    }

    private fun checkEmptyLoanCalc(editTextLoanCalc: EditText): Int{
        return if (editTextLoanCalc.text == null ||
            editTextLoanCalc.text.isEmpty() ||
            editTextLoanCalc.text.toString() == ""){
            1
        } else{
            Integer.parseInt(editTextLoanCalc.text.toString())
        }
    }
}