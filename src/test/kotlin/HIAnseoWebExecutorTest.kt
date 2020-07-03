import cn.breakbad.exchangerate.executor.ERROR_EXCHANGE_RATE
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
        TestCase.assertTrue(rate!= ERROR_EXCHANGE_RATE)
    }

    @Test
    fun testGetExchangeRateArray() {
        val us = Currency.getInstance(Locale.US)
        val japan = Currency.getInstance(Locale.JAPAN)
        val rates = exchangeRateExecutor.getExchangeRate(Currency.getInstance("CNY"), us, japan)
        TestCase.assertTrue(rates[us] is Double)
        TestCase.assertTrue(rates[japan] is Double)
    }

    @Test
    fun testGetExchangeRateList() {
        val rates = exchangeRateExecutor.getExchangeRate(Currency.getInstance("CNY")
                , listOf(Currency.getInstance(Locale.US), Currency.getInstance(Locale.JAPAN)))
        TestCase.assertTrue(rates[Currency.getInstance(Locale.US)] is Double)
        TestCase.assertTrue(rates[Currency.getInstance(Locale.JAPAN)] is Double)
    }

    @Test
    fun testGetExchangeRateAll() {
        val rates = exchangeRateExecutor.getAllExchangeRate(Currency.getInstance("GBP"))
        TestCase.assertTrue(rates[Currency.getInstance("HKD")] is Double)
        TestCase.assertTrue(rates[Currency.getInstance(Locale.JAPAN)] is Double)
    }


}