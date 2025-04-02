package study.practice.designPattern.proxy.virtual;

import study.practice.designPattern.proxy.ISubject;
import study.practice.designPattern.proxy.RealSubject;

public class VirtualProxy implements ISubject {
    private RealSubject subject;

    public VirtualProxy() {
    }

    @Override
    public void action() {
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.action();
        // 로직
        System.out.println("가상 프록시 객체");
    }
}
