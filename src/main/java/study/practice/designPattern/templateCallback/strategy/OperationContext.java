package study.practice.designPattern.templateCallback.strategy;

public class OperationContext {
    public OperationStrategy cal;

    public void setOperation(OperationStrategy cal){
        this.cal = cal;
    }

    public int calculate(int x, int y){
        System.out.println("연산 시작");
        int result = cal.calculate(x, y);
        System.out.println("연산 종료");
        return result;
    }
}
