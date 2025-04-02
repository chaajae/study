package study.practice.designPattern.proxy.Protection.implement;

public class Employee implements IEmployee{
    private String name;
    private RESPONSIBILITY position;

    public Employee(String name, RESPONSIBILITY position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RESPONSIBILITY getGrade(){
        return position;
    }

    @Override
    public String getInfo(IEmployee viewer) {
        return "Display" + getGrade().name() + " '" + getName() + "' personnel information.";
    }
}
