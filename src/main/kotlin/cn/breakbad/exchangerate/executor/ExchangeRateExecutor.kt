package cn.breakbad.exchangerate.executor

import cn.breakbad.exchangerate.ISO

public interface ExchangeRateExecutor {

    fun getExchangeRate(target: ISO, to: ISO): Double?

    fun getExchangeRate(target: ISO, vararg tos: ISO): Map<ISO, Double>? {
        return getExchangeRate(target, tos.asList())
    }

    fun getExchangeRate(target: ISO, tos: List<ISO>): Map<ISO, Double>?

    fun getAllExchangeRate(target: ISO): Map<ISO, Double>?

}