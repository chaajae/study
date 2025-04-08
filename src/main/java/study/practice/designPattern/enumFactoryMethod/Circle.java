package study.practice.designPattern.enumFactoryMethod;

public class Circle implements Shape{
    public String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("circle draw with " + color);
    }
}
