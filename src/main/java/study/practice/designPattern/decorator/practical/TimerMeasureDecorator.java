package study.practice.designPattern.decorator.practical;

public class TimerMeasureDecorator extends MyDataDecorator{
    public TimerMeasureDecorator(IData myDataObj) {
        super(myDataObj);
    }

    @Override
    public void setData(int data) {
        long startTime = System.nanoTime();
        super.setData(data);
        long endTime = System.nanoTime();
        long durationTimeSec = endTime - startTime;
        System.out.println(durationTimeSec + "n/s");
    }

    @Override
    public int getData() {
        long startTime = System.nanoTime();
        int result = super.getData();
        long endTime = System.nanoTime();
        long durationTimeSec = endTime - startTime;
        System.out.println(durationTimeSec + "n/s");
        return result;
    }
}
