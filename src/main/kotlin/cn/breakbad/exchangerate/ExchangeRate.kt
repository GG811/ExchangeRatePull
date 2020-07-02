package cn.breakbad.exchangerate

import cn.breakbad.exchangerate.executor.ExchangeRateExecutor
import cn.breakbad.exchangerate.executor.HlAnseoWebExecutor
import java.util.*

public open class ExchangeRate(private var exchangeRateExecutor: ExchangeRateExecutor = HlAnseoWebExecutor()) {

    open fun getExchangeRate(target: Currency, to: Currency): Double? {
        return exchangeRateExecutor.getExchangeRate(target, to)
    }

    open fun getExchangeRate(target: Currency, vararg tos: Currency): Map<Currency, Double>? {
        return getExchangeRate(target, tos.asList())
    }

    open fun getExchangeRate(target: Currency, tos: List<Currency>): Map<Currency, Double>? {
        return exchangeRateExecutor.getExchangeRate(target, tos)
    }

    open fun getAllExchangeRate(target: Currency): Map<Currency, Double>? {
        return exchangeRateExecutor.getAllExchangeRate(target)
    }

    fun setExchangeRateExecutor(exchangeRateExecutor: ExchangeRateExecutor){
        this.exchangeRateExecutor = exchangeRateExecutor
    }

}