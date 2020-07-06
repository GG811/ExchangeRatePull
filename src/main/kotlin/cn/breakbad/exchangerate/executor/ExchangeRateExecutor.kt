package cn.breakbad.exchangerate.executor

import java.util.*

const val  ERROR_EXCHANGE_RATE: Double = (-1).toDouble()

public interface ExchangeRateExecutor {


    fun getExchangeRate(target: Currency, to: Currency): Double

    fun getExchangeRate(target: Currency, vararg tos: Currency): Map<Currency, Double> {
        return getExchangeRate(target, tos.asList())
    }

    fun getExchangeRate(target: Currency, tos: List<Currency>): Map<Currency, Double>{
        return mapOf()
    }

    fun getAllExchangeRate(target: Currency): Map<Currency, Double>{
        return mapOf()
    }

}