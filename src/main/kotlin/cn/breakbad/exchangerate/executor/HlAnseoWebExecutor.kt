package cn.breakbad.exchangerate.executor

import cn.breakbad.exchangerate.ISO
import java.net.URL

/**
 * 抓取http://hl.anseo.cn/网址数据
 */
public open class HlAnseoWebExecutor : ExchangeRateExecutor {

    private val betweenRegex:Regex by lazy { Regex("当前汇率：</strong>(.*?)</p><p>") }

    override fun getExchangeRate(target: ISO, to: ISO): Double? {
        val responseContent = URL(getBetweenRateUrl(target, to)).readText()
        return betweenRegex.find(responseContent)?.groupValues?.last()?.toDoubleOrNull()
    }

    override fun getExchangeRate(target: ISO, tos: List<ISO>): Map<ISO, Double>? {
        return null
    }

    override fun getAllExchangeRate(target: ISO): Map<ISO, Double>? {
        return null
    }

    private fun getAllRateUrl(target: ISO): String {
        return "http://hl.anseo.cn/rate_${target.name}.aspx"
    }

    private fun getBetweenRateUrl(target: ISO, to: ISO): String {
        return "http://hl.anseo.cn/cal_${target.name}_To_${to.name}.aspx"
    }

}