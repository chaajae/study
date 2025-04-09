package study.practice.designPattern.templateCallback;

public class TestTemplate {
    public int workflow(TestCallback cb){
        System.out.println("Workflow 시작");
        int num = 100;
        return cb.execute(num);
    }
}
