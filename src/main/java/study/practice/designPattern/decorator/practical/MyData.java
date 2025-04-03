package study.practice.designPattern.decorator.practical;

public class MyData implements IData{
    private int data;

    @Override
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int getData() {
        return data;
    }
}
