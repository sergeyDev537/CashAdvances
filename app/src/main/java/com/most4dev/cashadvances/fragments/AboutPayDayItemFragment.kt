package com.most4dev.cashadvances.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.most4dev.cashadvances.R
import com.most4dev.cashadvances.model.ThemeModelLoans
import kotlinx.android.synthetic.main.fragment_about_pay_day_item.*

class AboutPayDayItemFragment : Fragment() {

    override fun onCreateView(
        inflaterAboutPayDayItem: LayoutInflater,
        containerAboutPayDayItem: ViewGroup?,
        savedInstanceStateAboutPayDayItem: Bundle?
    ): View? {
        return inflaterAboutPayDayItem.inflate(
            R.layout.fragment_about_pay_day_item,
            containerAboutPayDayItem,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (requireArguments().getSerializable("itemAboutPayDay") != null) {
            val themeModelAboutPayDayItem =
                requireArguments().getSerializable("itemAboutPayDay") as ThemeModelLoans
            textViewThemeDescLoans.text = themeModelAboutPayDayItem.description
        }
    }
}