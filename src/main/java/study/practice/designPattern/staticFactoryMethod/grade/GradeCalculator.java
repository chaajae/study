package study.practice.designPattern.staticFactoryMethod.grade;

public class GradeCalculator {
    public static Grade of(int score){
        if(score >= 90){
            return new A();
        }else if(score >= 80){
            return new B();
        }else if(score >= 70){
            return new C();
        }else if(score >= 60){
            return new D();
        }else{
            return new F();
        }
    }
}
