package study.practice.designPattern.proxy.logging;

import study.practice.designPattern.proxy.ISubject;
import study.practice.designPattern.proxy.RealSubject;

public class LoggingProxy implements ISubject {
    private RealSubject subject;

    public LoggingProxy(RealSubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        System.out.println("로깅");
        subject.action();
        System.out.println("로깅 프록시 객체");
        System.out.println("로깅");
    }
}
