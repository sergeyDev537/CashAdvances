package com.most4dev.cashadvances.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.most4dev.cashadvances.databinding.ItemLanguageBinding
import com.most4dev.cashadvances.managers.EmojiLoansManager
import com.most4dev.cashadvances.model.ModelLanguageLoans
import java.util.*

class LanguageAdapter(
    private var listLanguage: List<ModelLanguageLoans>
) : RecyclerView.Adapter<LanguageAdapter.LanguageAdapterViewHolder>() {

    var clickURLLanguage: ((ModelLanguageLoans) -> Unit)? = null

    override fun onCreateViewHolder(
        parentLanguage: ViewGroup, viewTypeLanguage: Int
    ): LanguageAdapterViewHolder {
        val bindingLanguage = ItemLanguageBinding.inflate(
            LayoutInflater.from(parentLanguage.context),
            parentLanguage,
            false
        )
        return LanguageAdapterViewHolder(bindingLanguage)
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(
        holderLanguage: LanguageAdapterViewHolder, positionLanguage: Int
    ) {
        holderLanguage.bindingLanguage.textViewLanguageLoans.text =
            EmojiLoansManager.localeToEmojiLoans(
                Locale("", listLanguage[positionLanguage].codeLanguage)
            ) + listLanguage[positionLanguage].nameLanguage
    }

    override fun getItemCount() = listLanguage.size

    inner class LanguageAdapterViewHolder(val bindingLanguage: ItemLanguageBinding) :
        RecyclerView.ViewHolder(bindingLanguage.root) {
        init {
            bindingLanguage.constraintLayoutLanguage.setOnClickListener {
                clickURLLanguage?.invoke(
                    listLanguage[adapterPosition]
                )
            }
        }
    }
}