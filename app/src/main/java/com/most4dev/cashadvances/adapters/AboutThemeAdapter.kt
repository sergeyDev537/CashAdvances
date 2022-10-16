package com.most4dev.cashadvances.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.most4dev.cashadvances.databinding.ItemAboutThemeBinding
import com.most4dev.cashadvances.model.ThemeModelLoans

open class AboutThemeAdapter(
    private var listDataJSONAbout: List<ThemeModelLoans>
) : RecyclerView.Adapter<AboutThemeAdapter.AboutThemeViewHolder>() {

    var clickURLAbout: ((ThemeModelLoans) -> Unit)? = null

    override fun onCreateViewHolder(
        parentAbout: ViewGroup,
        viewTypeAbout: Int
    ): AboutThemeViewHolder {
        val bindingAbout = ItemAboutThemeBinding
            .inflate(LayoutInflater.from(parentAbout.context), parentAbout, false)
        return AboutThemeViewHolder(bindingAbout)
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(holderAbout: AboutThemeViewHolder, positionAbout: Int) {
        holderAbout.bindingAbout.nameThemeLoans.text = listDataJSONAbout[positionAbout].theme
    }

    override fun getItemCount() = listDataJSONAbout.size

    @SuppressLint("NotifyDataSetChanged")
    open fun setItemsAbout(listAbout: List<ThemeModelLoans>) {
        listDataJSONAbout = listAbout
        notifyDataSetChanged()
    }

    inner class AboutThemeViewHolder(val bindingAbout: ItemAboutThemeBinding) :
        RecyclerView.ViewHolder(bindingAbout.root) {
        init {
            bindingAbout.nameThemeLoans.setOnClickListener {
                clickURLAbout?.invoke(
                    listDataJSONAbout[adapterPosition]
                )
            }
        }
    }
}