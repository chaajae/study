package study.practice.designPattern.proxy.Protection.implement;

public interface IEmployee {
    String getName();
    RESPONSIBILITY getGrade();
    String getInfo(IEmployee viewer);
}
