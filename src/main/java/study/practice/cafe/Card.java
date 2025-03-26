package study.practice.cafe;

public class Card implements PaymentStrategy{
    private String cardCompany;
    private String monthly;

    public Card(String cardCompany, String monthly) {
        this.cardCompany = cardCompany;
        this.monthly = monthly;
    }

    @Override
    public void pay() {
        System.out.printf("%s로 %s 결제가 완료되었습니다.\n", cardCompany, monthly);
    }
}
