package com.most4dev.cashadvances.managers

import org.json.JSONObject

class JSONManager {

    companion object{

        fun parseJsonFormatPayDayLink(strJSON: String): String {
            val jsonRoot = JSONObject(strJSON)
            return jsonRoot.getString("payday_link")
        }

        fun parseJsonFormatInstallmentLink(strJSON: String): String {
            val jsonRoot = JSONObject(strJSON)
            return jsonRoot.getString("installment_link")
        }

    }

}