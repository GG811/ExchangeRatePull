package cn.breakbad.exchangerate

import cn.breakbad.exchangerate.executor.ERROR_EXCHANGE_RATE
import cn.breakbad.exchangerate.executor.ExchangeRateExecutor
import cn.breakbad.exchangerate.executor.HlAnseoWebExecutor
import cn.breakbad.exchangerate.util.CurrencyUtil
import java.util.Currency

public open class ExchangeRate(private var exchangeRateExecutor: ExchangeRateExecutor = HlAnseoWebExecutor()) {

    private val currencyUtil: CurrencyUtil by lazy { CurrencyUtil() }

    open fun getExchangeRate(targetCurrencyCode: String, toCurrencyCode: String): Double {
        val target = currencyUtil.getCurrency(targetCurrencyCode) ?: return ERROR_EXCHANGE_RATE
        val to = currencyUtil.getCurrency(toCurrencyCode) ?: return ERROR_EXCHANGE_RATE
        return getExchangeRate(target, to)
    }

    open fun getExchangeRate(targetCurrencyCode: String, vararg toCurrencyCodes: String): Map<Currency, Double> {
        return getExchangeRate(targetCurrencyCode, toCurrencyCodes.asList())
    }

    open fun getExchangeRate(targetCurrencyCode: String, tos: List<String>): Map<Currency, Double> {
        val target = currencyUtil.getCurrency(targetCurrencyCode) ?: return mapOf()
        val toArray = currencyUtil.getCurrencyArray(tos) ?: return mapOf()
        return getExchangeRate(target, toArray)
    }

    open fun getAllExchangeRate(targetCurrencyCode: String): Map<Currency, Double> {
        val target = currencyUtil.getCurrency(targetCurrencyCode) ?: return mapOf()
        return exchangeRateExecutor.getAllExchangeRate(target)
    }

    open fun getExchangeRate(target: Currency, to: Currency): Double {
        return exchangeRateExecutor.getExchangeRate(target, to)
    }

    open fun getExchangeRate(target: Currency, vararg tos: Currency): Map<Currency, Double> {
        return getExchangeRate(target, tos.asList())
    }

    open fun getExchangeRate(target: Currency, tos: List<Currency>): Map<Currency, Double> {
        return exchangeRateExecutor.getExchangeRate(target, tos)
    }

    open fun getAllExchangeRate(target: Currency): Map<Currency, Double>? {
        return exchangeRateExecutor.getAllExchangeRate(target)
    }

    private fun setExchangeRateExecutor(exchangeRateExecutor: ExchangeRateExecutor) {
        this.exchangeRateExecutor = exchangeRateExecutor
    }


}