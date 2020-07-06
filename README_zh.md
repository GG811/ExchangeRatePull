# ExchangeRatePull

一个获取汇率的类库

使用 [ISO 4217](https://zh.wikipedia.org/wiki/ISO_4217) 币种代码

## 使用

下载最新的JAR或者从 Maven central中引入
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

### 使用示例


获取两个币种之间的汇率

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


获取一个币种对多个币种的汇率

```
// kotlin
val exchangeRate = ExchangeRate()
val target = Currency.getInstance(Locale.US)
val arrayTos = listOf(Currency.getInstance("CNY"),
                Currency.getInstance(Locale.JAPAN),
                Currency.getInstance(Locale.FRENCH))

val rate:Map<Currency,Double>? = exchangeRate.getExchangeRate(target, arrayTos)
 
```

获取一个币种对所有币种的汇率


```
// kotlin
val exchangeRate = ExchangeRate()
val target = Currency.getInstance(Locale.CHINA)
val allRate:Map<Currency,Double>? = exchangeRate.getAllExchangeRate(target)

```

### 执行器说明

executor | url | 支持多查询
---|---|---
HIAnseWebExecutor | http://hl.anseo.cn | true
IP138WebExecutor | https://qq.ip138.com/hl.asp | false
