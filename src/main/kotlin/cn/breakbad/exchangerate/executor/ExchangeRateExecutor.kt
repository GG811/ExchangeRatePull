package cn.breakbad.exchangerate.executor

import java.util.*

public interface ExchangeRateExecutor {

    fun getExchangeRate(target: Currency, to: Currency): Double?

    fun getExchangeRate(target: Currency, vararg tos: Currency): Map<Currency, Double>? {
        return getExchangeRate(target, tos.asList())
    }

    fun getExchangeRate(target: Currency, tos: List<Currency>): Map<Currency, Double>?

    fun getAllExchangeRate(target: Currency): Map<Currency, Double>?

}