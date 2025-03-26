package study.practice.cafe;

public class Crypto implements PaymentStrategy {
    private String cryptoMarket;

    public Crypto(String cryptoMarket) {
        this.cryptoMarket = cryptoMarket;
    }

    @Override
    public void pay() {
        System.out.printf("%s 거래소에서 암호화페 결제가 완료되었습니다.\n", cryptoMarket);
    }
}
