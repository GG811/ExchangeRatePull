# ExchangeRatePull

A library for obtaining exchange rates

use [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code

[中文文档](https://github.com/GG811/ExchangeRatePull/blob/master/README_zh.md)

## Usage

Download the latest JAR or grab from Maven central at the coordinates 
```
// gralde
implementation "com.github.gg811:pull-exchangerate:0.0.1"
```
```
// pom
<dependency>
  <groupId>com.github.gg811</groupId>
  <artifactId>pull-exchangerate</artifactId>
  <version>0.0.1</version>
</dependency>
```
### Get ExchangeRate


Between two countries
```
// kotlin
val exchangeRate = ExchangeRate()
val rate = exchangeRate.getExchangeRate("ALL", "ANG")
println(rate)

```
```
// java
ExchangeRate exchangeRate = new ExchangeRate();
double rate = exchangeRate.getExchangeRate("ALL","ANG");
System.out.println(rate);

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

### Executor Description

executor | url | multi-query
---|---|---
HIAnseWebExecutor | http://hl.anseo.cn | true
IP138WebExecutor | https://qq.ip138.com/hl.asp | false
