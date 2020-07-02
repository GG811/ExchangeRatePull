# ExchangeRatePull

a library for obtaining exchange rates

## Usage

Download the latest JAR or grab from Maven central at the coordinates 
```
todo upload maven
```

### Get ExchangeRate

Between two countries
```
val exchangeRate = ExchangeRate()
val target = Currency.getInstance(Locale.US)
val to  = Currency.getInstance("CNY")
val rate:Double? = exchangeRate.getExchangeRate(target,to)

```

One country to many countries

```
val exchangeRate = ExchangeRate()
val target = Currency.getInstance(Locale.US)
val arrayTos = listOf(Currency.getInstance("CNY"),
                Currency.getInstance(Locale.JAPAN),
                Currency.getInstance(Locale.FRENCH))

val rate:Map<Currency,Double>? = exchangeRate.getExchangeRate(target, arrayTos)
 
```

All exchange rates of a country


```
val exchangeRate = ExchangeRate()
val target = Currency.getInstance(Locale.CHINA)
val allRate:Map<Currency,Double>? = exchangeRate.getAllExchangeRate(target)

```
