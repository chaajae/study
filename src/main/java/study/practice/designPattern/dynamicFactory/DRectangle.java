package study.practice.designPattern.dynamicFactory;

public class DRectangle implements DShape{
    private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("rectangle draw with " + color);
    }
}
