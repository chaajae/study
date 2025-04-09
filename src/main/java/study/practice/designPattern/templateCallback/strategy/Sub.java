package study.practice.designPattern.templateCallback.strategy;

public class Sub implements OperationStrategy{
    @Override
    public int calculate(int x, int y) {
        return x - y;
    }
}
