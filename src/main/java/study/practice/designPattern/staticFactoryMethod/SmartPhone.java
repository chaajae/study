package study.practice.designPattern.staticFactoryMethod;

public interface SmartPhone {

    void information();

    static SmartPhone getPhone(int price){
        switch (price){
            case 1000 :
                return new Huawei();
            case 2000 :
                return new Galaxy();
            case 3000 :
                return new IPhone();
        }
        return null;
    }
    static SmartPhone getSamsungPhone(){
        return new Galaxy();
    }

    static SmartPhone getApplePhone(){
        return new IPhone();
    }

    static SmartPhone getChinesePhone(){
        return new Huawei();
    }
}
