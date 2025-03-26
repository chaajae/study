package study.practice.cafe;

public class Americano implements MenuStrategy {
    private String extraction;
    private String temperature;

    public Americano(String extraction, String temperature) {
        this.extraction = extraction;
        this.temperature = temperature;
    }

    public void brew() {
        System.out.printf("주문하신 %s %s 아메리카노 나왔습니다.%n", extraction, temperature);
    }
}
