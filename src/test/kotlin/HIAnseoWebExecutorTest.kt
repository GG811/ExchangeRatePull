import cn.breakbad.exchangerate.ISO
import cn.breakbad.exchangerate.executor.HlAnseoWebExecutor
import junit.framework.TestCase
import org.junit.Test

class HIAnseoWebExecutorTest {
    private val exchangeRateExecutor = HlAnseoWebExecutor()


    @Test
    fun testGetExchangeRateSingle() {
        val rate = exchangeRateExecutor.getExchangeRate(ISO.CNY, ISO.USD)
        TestCase.assertTrue(rate is Double)
    }

    @Test
    fun testGetExchangeRateArray() {
        val rates = exchangeRateExecutor.getExchangeRate(ISO.CNY, ISO.USD, ISO.JPY)
        TestCase.assertTrue(rates?.get(ISO.USD) is Double)
        TestCase.assertTrue(rates?.get(ISO.JPY) is Double)
    }

    @Test
    fun testGetExchangeRateList() {
        val rates = exchangeRateExecutor.getExchangeRate(ISO.CNY, listOf(ISO.USD, ISO.JPY))
        TestCase.assertTrue(rates?.get(ISO.USD) is Double)
        TestCase.assertTrue(rates?.get(ISO.JPY) is Double)
    }

    @Test
    fun testGetExchangeRateAll() {
        val rates = exchangeRateExecutor.getAllExchangeRate(ISO.CNY)
        TestCase.assertTrue(rates?.get(ISO.USD) is Double)
        TestCase.assertTrue(rates?.get(ISO.JPY) is Double)
    }


}