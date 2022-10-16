package com.most4dev.cashadvances.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.most4dev.cashadvances.R
import com.most4dev.cashadvances.activity.MainActivity
import com.most4dev.cashadvances.adapters.AboutThemeAdapter
import com.most4dev.cashadvances.viewModels.AboutViewModelLoans
import kotlinx.android.synthetic.main.fragment_about_payday.*
import java.util.ArrayList

class AboutPaydayFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModelLoans
    private lateinit var adapterThemeAboutPayday: AboutThemeAdapter

    override fun onCreateView(
        inflaterAboutPayday: LayoutInflater,
        containerAboutPayday: ViewGroup?,
        savedInstanceStateAboutPayday: Bundle?
    ): View? {
        aboutViewModel = ViewModelProvider(this)[AboutViewModelLoans::class.java]
        return inflaterAboutPayday.inflate(
            R.layout.fragment_about_payday,
            containerAboutPayday,
            false
        )
    }

    override fun onViewCreated(viewAboutPayday: View, savedInstanceStateAboutPayday: Bundle?) {
        super.onViewCreated(viewAboutPayday, savedInstanceStateAboutPayday)
        createAdapterAboutPayday()

        aboutViewModel.getListThemeLoans()!!.observe(viewLifecycleOwner) {
            adapterThemeAboutPayday.setItemsAbout(it)
        }
    }

    private fun createAdapterAboutPayday() {
        adapterThemeAboutPayday = AboutThemeAdapter(
            ArrayList()
        )

        adapterThemeAboutPayday.clickURLAbout = {
            val bundle = Bundle()
            bundle.putSerializable("itemAboutPayDay", it)
            (requireActivity() as MainActivity).navControllerCashAdvance.navigate(
                R.id.action_aboutPaydayFragment_to_aboutPayDayItemFragment,
                bundle
            )
        }

        val recyclerViewBankViewHomeAboutPayday: RecyclerView = recyclerViewAboutPayDayLoans
        recyclerViewBankViewHomeAboutPayday.layoutManager = LinearLayoutManager(context)
        recyclerViewBankViewHomeAboutPayday.adapter = adapterThemeAboutPayday
    }
}