import cn.breakbad.exchangerate.ExchangeRate
import cn.breakbad.exchangerate.executor.ERROR_EXCHANGE_RATE
import cn.breakbad.exchangerate.executor.IP138WebExecutor
import junit.framework.TestCase
import org.junit.Test
import java.util.*

class IP138WebExecutorTest {
    private val exchangeRate = ExchangeRate(IP138WebExecutor())

    @Test
    fun testGetExchangeRate() {
        val rate =  exchangeRate.getExchangeRate(Currency.getInstance(Locale.CHINA),Currency.getInstance(Locale.JAPAN))
        TestCase.assertTrue(rate!= ERROR_EXCHANGE_RATE)
    }
}