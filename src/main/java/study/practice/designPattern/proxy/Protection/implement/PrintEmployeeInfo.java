package study.practice.designPattern.proxy.Protection.implement;

import java.util.List;

public class PrintEmployeeInfo {
    private IEmployee viewer;

    public PrintEmployeeInfo(IEmployee viewer) {
        this.viewer = viewer;
    }

    public void printAllInfo(List<IEmployee> employees) {
        employees.stream()
                .map(e -> e.getInfo(viewer))
                .forEach(System.out::println);
    }
}
