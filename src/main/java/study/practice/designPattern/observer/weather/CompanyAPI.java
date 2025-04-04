package study.practice.designPattern.observer.weather;

public class CompanyAPI implements WeatherObserver{
    private String company;

    public CompanyAPI(String company) {
        this.company = company;
    }

    @Override
    public void display(WeatherAPI api) {
        System.out.printf("%s에서 날씨 조회중입니다.\n", company);
    }
}
