package study.practice.designPattern.dynamicFactory;

public class DTriangle implements DShape{
    private String color;
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Triangle draw with " + color);
    }
}
