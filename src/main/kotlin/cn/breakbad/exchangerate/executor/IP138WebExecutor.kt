package cn.breakbad.exchangerate.executor

import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class IP138WebExecutor : ExchangeRateExecutor {

    private val regex: Regex by lazy { Regex("</p></td><td><p>(.*?)</p></td></tr></table></tr></table>") }
    override fun getExchangeRate(target: Currency, to: Currency): Double {
        println(getBetweenRateUrl(target, to))
        val connection = URL(getBetweenRateUrl(target, to)).openConnection() as HttpURLConnection
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")
        val responseContent = connection.inputStream.readBytes().toString(Charsets.UTF_8)
        return regex.find(responseContent)?.groupValues?.last()?.toDoubleOrNull()?:ERROR_EXCHANGE_RATE
    }

    private fun getBetweenRateUrl(target: Currency, to: Currency): String {
        return "https://qq.ip138.com/hl.asp?from=${target.currencyCode}&to=${to.currencyCode}&q=1"
    }
}