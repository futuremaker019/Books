package observer.observer;

import observer.subject.WeatherData;

public class CurrentConditionDisplay implements Observer, Display {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    /*
        현재상태 화면 생성시 weatherData 의 정보를 받아 register에 등록하여
     */
    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /*
        update 호출시 기온, 습도를 변경하고 display를 호출한다.
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("temperature = " + temperature);
        System.out.println("humidity = " + humidity);
    }

}
