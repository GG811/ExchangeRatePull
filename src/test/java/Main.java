import cn.breakbad.exchangerate.ExchangeRate;

public class Main {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate();
        double rate = exchangeRate.getExchangeRate("ALL","ANG");
        System.out.println(rate);
    }
}
