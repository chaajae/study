package study.practice.designPattern.templateCallback.practical;

import study.practice.designPattern.templateCallback.strategy.OperationStrategy;

public class OperationTemplate {
    public int calculate(int x, int y, OperationStrategy cal){
        System.out.println("연산 시작");
        int result = cal.calculate(x, y);
        System.out.println("연산 종료");
        return result;
    }
}
