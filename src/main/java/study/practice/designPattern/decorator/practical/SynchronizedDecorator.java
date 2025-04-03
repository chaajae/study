package study.practice.designPattern.decorator.practical;

public class SynchronizedDecorator extends MyDataDecorator{
    public SynchronizedDecorator(IData myDataObj) {
        super(myDataObj);
    }

    @Override
    public void setData(int data) {
        synchronized (this){
            System.out.println("동기화된 data 처리를 시작합니다.");
            super.setData(data);
            System.out.println("동기화된 data 처리를 완료하였습니다.");
        }
    }

    @Override
    public int getData() {
        synchronized (this){
            System.out.println("동기화된 data 처리를 시작합니다.");
            int result = super.getData();
            System.out.println("동기화된 data 처리를 완료하였습니다.");
            return result;
        }
    }
}
