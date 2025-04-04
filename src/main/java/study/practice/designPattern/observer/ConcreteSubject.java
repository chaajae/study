package study.practice.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements ISubject{

    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
        System.out.println(o + "구독 완료");
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
        System.out.println(o + "구독 취소");
    }

    @Override
    public void notifyObserver() {
        for (IObserver o : observers) {
            o.update();
        }

    }
}
