package study.practice.designPattern.decorator.practical;

public abstract class MyDataDecorator implements IData{
    private IData myDataObj;

    public MyDataDecorator(IData myDataObj) {
        this.myDataObj = myDataObj;
    }

    @Override
    public void setData(int data) {
        this.myDataObj.setData(data);
    }

    @Override
    public int getData() {
        return myDataObj.getData();
    }
}
