package study.practice.designPattern.proxy.normal;

import study.practice.designPattern.proxy.ISubject;
import study.practice.designPattern.proxy.RealSubject;

public class NormalProxy implements ISubject {

    private RealSubject subject;

    public NormalProxy(RealSubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        subject.action();
        // 로직 추가
        System.out.println("기본 프록시 객체");
    }
}
