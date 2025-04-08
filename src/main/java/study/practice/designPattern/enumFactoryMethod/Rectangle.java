package study.practice.designPattern.enumFactoryMethod;

public class Rectangle implements Shape{
    public String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("rectangle draw with " + color);
    }
}
