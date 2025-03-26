package study.practice.cafe;

public interface MenuStrategy {
    void brew();

    default void test(){
        System.out.println("TEST");
    }
}
