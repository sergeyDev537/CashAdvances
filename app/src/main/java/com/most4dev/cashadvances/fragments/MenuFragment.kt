package com.most4dev.cashadvances.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.most4dev.cashadvances.Config
import com.most4dev.cashadvances.R
import com.most4dev.cashadvances.activity.MainActivity
import com.most4dev.cashadvances.managers.URLLoansManager
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflaterMenu: LayoutInflater,
        containerMenu: ViewGroup?,
        savedInstanceStateMenu: Bundle?
    ): View? {
        return inflaterMenu.inflate(
            R.layout.fragment_menu,
            containerMenu,
            false
        )
    }

    override fun onViewCreated(viewMenu: View, savedInstanceStateMenu: Bundle?) {
        super.onViewCreated(viewMenu, savedInstanceStateMenu)
        if (requireActivity().intent.getStringExtra("codeRequest") != null) {
            checkCodeRequestMenu(requireActivity().intent.getStringExtra("codeRequest")!!)
        }
        clickButtonsMenu()
    }

    private fun clickButtonsMenu() {
        buttonPaydayLoansMenu.setOnClickListener {
            URLLoansManager.openURLEmbeddedBrowserLoans(requireContext(), Config.URL_PAYDAY_LOANS)
        }

        buttonInstallmentLoansMenu.setOnClickListener {
            URLLoansManager.openURLEmbeddedBrowserLoans(
                requireContext(),
                Config.URL_INSTALLMENT_LOANS
            )
        }

        buttonLegalityMenuUS.setOnClickListener {
            //TODO
        }

        buttonPrivacyPolicyMenu.setOnClickListener {
            //TODO
        }

        buttonLoanCalculatorMenu.setOnClickListener {
            (requireActivity() as MainActivity).navControllerCashAdvance.navigate(
                R.id.action_menuFragment_to_loanCalculatorFragment
            )
        }

        buttonAboutPaydayMenu.setOnClickListener {
            (requireActivity() as MainActivity).navControllerCashAdvance.navigate(
                R.id.action_menuFragment_to_aboutPaydayFragment
            )
        }
    }

    private fun checkCodeRequestMenu(stringExtraMenu: String) {
        if (stringExtraMenu.contains("1ok")) {
            buttonPaydayLoansMenu.visibility = View.VISIBLE
            buttonInstallmentLoansMenu.visibility = View.VISIBLE
            buttonLegalityMenuUS.visibility = View.VISIBLE
            buttonPrivacyPolicyMenu.visibility = View.VISIBLE
            buttonLoanCalculatorMenu.visibility = View.VISIBLE
            buttonAboutPaydayMenu.visibility = View.VISIBLE
        } else {
            buttonPaydayLoansMenu.visibility = View.GONE
            buttonInstallmentLoansMenu.visibility = View.GONE
            buttonLegalityMenuUS.visibility = View.VISIBLE
            buttonPrivacyPolicyMenu.visibility = View.VISIBLE
            buttonLoanCalculatorMenu.visibility = View.VISIBLE
            buttonAboutPaydayMenu.visibility = View.VISIBLE
        }
    }
}