import cn.breakbad.exchangerate.executor.HlAnseoWebExecutor
import junit.framework.TestCase
import org.junit.Test
import java.util.*

class HIAnseoWebExecutorTest {
    private val exchangeRateExecutor = HlAnseoWebExecutor()

    @Test
    fun testGetExchangeRateSingle() {

        val rate = exchangeRateExecutor.getExchangeRate(Currency.getInstance("CNY")
                , Currency.getInstance(Locale.US))
        TestCase.assertTrue(rate is Double)
    }

    @Test
    fun testGetExchangeRateArray() {
        val us = Currency.getInstance(Locale.US)
        val japan = Currency.getInstance(Locale.JAPAN)
        val rates = exchangeRateExecutor.getExchangeRate(Currency.getInstance("CNY"), us, japan)
        TestCase.assertTrue(rates?.get(us) is Double)
        TestCase.assertTrue(rates?.get(japan) is Double)
    }

    @Test
    fun testGetExchangeRateList() {
        val rates = exchangeRateExecutor.getExchangeRate(Currency.getInstance("CNY")
                , listOf(Currency.getInstance(Locale.US), Currency.getInstance(Locale.JAPAN)))
        TestCase.assertTrue(rates?.get(Currency.getInstance(Locale.US)) is Double)
        TestCase.assertTrue(rates?.get(Currency.getInstance(Locale.JAPAN)) is Double)
    }

    @Test
    fun testGetExchangeRateAll() {
        val rates = exchangeRateExecutor.getAllExchangeRate(Currency.getInstance("GBP"))
        TestCase.assertTrue(rates?.get(Currency.getInstance("HKD")) is Double)
        TestCase.assertTrue(rates?.get(Currency.getInstance(Locale.JAPAN)) is Double)
    }


}