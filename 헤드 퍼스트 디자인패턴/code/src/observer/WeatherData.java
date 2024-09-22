package observer;

import java.util.List;

public class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    /*
        weather 데이터가 생성시 모든 옵저버를 등록한다.
     */
    public WeatherData(List<Observer> observers) {
        this.observers = observers;
    }

    // 옵저버 등록
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    // 옵저버 삭제
    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    // 모든 옵저버의 업데이트
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

}
