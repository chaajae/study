package study.practice.designPattern.strategy;

public interface MenuStrategy {
    void brew();

    default void test(){
        System.out.println("TEST");
    }
}
