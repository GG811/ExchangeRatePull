package cn.breakbad.exchangerate.executor

import java.lang.Exception
import java.net.URL
import java.util.*

/**
 * 抓取http://hl.anseo.cn/网址数据
 */
public open class HlAnseoWebExecutor : ExchangeRateExecutor {

    private val betweenRegex: Regex by lazy { Regex("当前汇率：</strong>(.*?)</p><p>") }
    private val nameRegex: Regex by lazy { Regex("<title>(.*?)汇率查询") }

    override fun getExchangeRate(target: Currency, to: Currency): Double {
        val responseContent = URL(getBetweenRateUrl(target, to)).readText()
        return betweenRegex.find(responseContent)?.groupValues?.last()?.toDoubleOrNull()?:errorExchangeRate
    }

    override fun getExchangeRate(target: Currency, tos: List<Currency>): Map<Currency, Double> {
        return getAllExchangeRate(target).filter {
            tos.contains(it.key)
        }
    }

    override fun getAllExchangeRate(target: Currency): Map<Currency, Double> {
        val responseContent = URL(getAllRateUrl(target)).readText()
        val currencyName = getCurrencyName(responseContent)
        val currencyMap = mutableMapOf<Currency, Double>()

        val regex = Regex("1 $currencyName = (.*?) <a href=\".*</a>\\((.*?)\\)")
        regex.findAll(responseContent).iterator().forEach { matchResult ->
            val values = matchResult.groupValues
            if (values.size >= 2) {
                try {
                    currencyMap[Currency.getInstance(values[values.size - 1])] =
                            values[values.size - 2].toDouble()
                } catch (e: Exception) {
                    println(values+e)
                }
            }
        }
        return currencyMap
    }

    private fun getCurrencyName(responseContent: String): String? {
        return nameRegex.find(responseContent)?.groupValues?.last()
    }

    private fun getAllRateUrl(target: Currency): String {
        return "http://hl.anseo.cn/rate_${target.currencyCode}.aspx"
    }

    private fun getBetweenRateUrl(target: Currency, to: Currency): String {
        return "http://hl.anseo.cn/cal_${target.currencyCode}_To_${to.currencyCode}.aspx"
    }

}