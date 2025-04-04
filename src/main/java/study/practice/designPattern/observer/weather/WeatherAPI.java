package study.practice.designPattern.observer.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherAPI implements WeatherSubject{
    public float temp;
    public float humidity;
    public float pressure;

    List<WeatherObserver> subscribers = new ArrayList<>();

    public void measurementsChanged(){
        temp = new Random().nextFloat() * 100;
        humidity = new Random().nextFloat() * 100;
        pressure = new Random().nextFloat() * 100;

        notifyObservers();
    }
    @Override
    public void registerObserver(WeatherObserver o) {
        subscribers.add(o);
    }

    @Override
    public void removeObserver(WeatherObserver o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver o : subscribers) {
            o.display(this);
        }
        System.out.println();
    }
}
