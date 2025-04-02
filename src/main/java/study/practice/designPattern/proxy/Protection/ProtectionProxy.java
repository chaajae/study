package study.practice.designPattern.proxy.Protection;

import study.practice.designPattern.proxy.ISubject;
import study.practice.designPattern.proxy.RealSubject;

public class ProtectionProxy implements ISubject {
    private RealSubject subject;
    private boolean access;

    public ProtectionProxy(RealSubject subject, boolean access) {
        this.subject = subject;
        this.access = access;
    }

    @Override
    public void action() {
        if (access) {
            subject.action();
            // 로직
            System.out.println("보호 프록시 객체");
        }

    }
}
