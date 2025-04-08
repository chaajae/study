package study.practice.designPattern.dynamicFactory;

public class DCircle implements DShape{
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("circle draw with " + color);
    }
}
