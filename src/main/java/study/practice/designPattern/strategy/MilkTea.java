package study.practice.designPattern.strategy;

public class MilkTea implements MenuStrategy {
    private String temperature;
    private String sugar;

    public MilkTea(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public void brew() {
        System.out.printf("주문하신 %s 밀크티 나왔습니다.%n", temperature);
    }
}
