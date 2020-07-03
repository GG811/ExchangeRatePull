package cn.breakbad.exchangerate.util

import java.util.*

class CurrencyUtil {
    fun getCurrencyArray(currencyCodes: List<String>): List<Currency>? {
        val list = mutableListOf<Currency>()
        currencyCodes.forEach { currencyCode ->
            val currency = getCurrency(currencyCode)
            if (currency!=null) list.add(currency)
        }
        return if (list.isEmpty()) null else list
    }

    fun getCurrency(currencyCode: String): Currency? {
        return try {
            Currency.getInstance(currencyCode)
        } catch (e: Exception) {
            null
        }
    }
}