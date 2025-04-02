package study.practice.designPattern.proxy.dynamic;

public class Tiger implements Animal{
    @Override
    public void eat() {
        System.out.println("호랑이가 음식을 냠냠");
    }
}
