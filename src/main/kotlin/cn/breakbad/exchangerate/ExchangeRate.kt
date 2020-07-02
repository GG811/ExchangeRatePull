package cn.breakbad.exchangerate

import cn.breakbad.exchangerate.executor.ExchangeRateExecutor
import cn.breakbad.exchangerate.executor.HlAnseoWebExecutor

public open class ExchangeRate(private var exchangeRateExecutor: ExchangeRateExecutor = HlAnseoWebExecutor()) {

    open fun getExchangeRate(target: ISO, to: ISO): Double? {
        return exchangeRateExecutor.getExchangeRate(target, to)
    }

    open fun getExchangeRate(target: ISO, vararg tos: ISO): Map<ISO, Double>? {
        return getExchangeRate(target, tos.asList())
    }

    open fun getExchangeRate(target: ISO, tos: List<ISO>): Map<ISO, Double>? {
        return exchangeRateExecutor.getExchangeRate(target, tos)
    }

    open fun getAllExchangeRate(target: ISO): Map<ISO, Double>? {
        return exchangeRateExecutor.getAllExchangeRate(target)
    }

    fun setExchangeRateExecutor(exchangeRateExecutor: ExchangeRateExecutor){
        this.exchangeRateExecutor = exchangeRateExecutor
    }

}