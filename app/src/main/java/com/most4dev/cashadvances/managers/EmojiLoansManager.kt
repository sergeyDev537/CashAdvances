package com.most4dev.cashadvances.managers

import java.util.*

class EmojiLoansManager {

    companion object {

        fun localeToEmojiLoans(localeDefault: Locale): String {
            val countryCodeLoans = localeDefault.country
            val firstLetterLoans = Character.codePointAt(countryCodeLoans, 0) - 0x41 + 0x1F1E6
            val secondLetterLoans = Character.codePointAt(countryCodeLoans, 1) - 0x41 + 0x1F1E6
            return String(Character.toChars(firstLetterLoans)) + String(
                Character.toChars(
                    secondLetterLoans
                )
            )
        }
    }
}