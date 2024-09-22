### 옵저버 패턴

#### 객체 생성

Weather(Subject) 생성하여 각 Observer들을 등록한다.

```java
// Executor

WeatherData weatherData = new WeatherData();

CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
StaticDisplay staticDisplay = new StaticDisplay(weatherData);
ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
```

Subject를 상속받은 Weather는 Observer들에게 정보를 한번에 보내줘야한다. 여기서는 `setMeasurements`를 호출하여 데이터를 저장하는 동시에 새로운 데이터를 모든 Observer들에게 보내준다.

모든 옵저버들의 update 메서드를 호출한다.

```java
// WeatherData

@Override
public void notifyObservers() {
    for (Observer observer : observers) {
        observer.update(this.temperature, this.humidity, this.pressure);
    }
}

/*
    기상 정보가 변경되면 모든 옵저버에 알림
*/
public void measurementsChanged() {
    this.notifyObservers();
}

public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
}
```


