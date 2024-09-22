package observer;

import observer.observer.CurrentConditionDisplay;
import observer.observer.ForecastDisplay;
import observer.observer.StaticDisplay;
import observer.subject.WeatherData;

public class Executor {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StaticDisplay staticDisplay = new StaticDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("-----");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("-----");
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
