package study.practice.designPattern.strategy;

public class Cash implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("현금 결제가 완료되었습니다.");
    }
}
