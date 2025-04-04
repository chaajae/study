package study.practice.designPattern.observer.weather;

public class Monitoring implements WeatherObserver{
    private String from;

    public Monitoring(String from) {
        this.from = from;
    }

    @Override
    public void display(WeatherAPI api) {
        System.out.printf("%s에서 모니터링 중입니다.\n", from);
    }
}
