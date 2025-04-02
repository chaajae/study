package study.practice.designPattern.inheritance;

import lombok.ToString;

import java.util.Collection;

@ToString
public class Parent {
    private int num = 0;

    public <E> void add(E e){
        num++;
        System.out.println("PARENT ADD");
    }

    public <E> void  addAll(Collection<? extends E> c){
        for (E e : c) {
            this.add(e);
        }
    }

    public int getCount(){
        return num;
    }

    public void test() {

    }
}
