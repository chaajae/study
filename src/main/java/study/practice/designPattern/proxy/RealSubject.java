package study.practice.designPattern.proxy;

public class RealSubject implements ISubject{
    @Override
    public void action() {
        System.out.println("원본 객체");
    }
}
