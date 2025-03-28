package study.practice.designPattern.inheritance;

import java.util.Collection;

public class Child extends Parent {
    private int count = 0;
    @Override
    public <E> void add(E e) {
        count++;
        System.out.println("CHILD ADD");
        super.add(e);
    }

    @Override
    public <E> void addAll(Collection<? extends E> c) {
        count += c.size();
        super.addAll(c);
    }

    public int getCount(){
        return count;
    }
}
