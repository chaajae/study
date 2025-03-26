package study.practice.cafe;

public class Latte implements MenuStrategy {
    private String extraction;
    private String temperature;

    public Latte(String extraction, String temperature) {
        this.extraction = extraction;
        this.temperature = temperature;
    }

    @Override
    public void brew() {
        System.out.printf("주문하신 %s %s 라떼 나왔습니다.%n", extraction, temperature);
    }

    @Override
    public void test(){
        System.out.println("라떼 테스트");
    }
}
