package study.practice.designPattern.staticFactoryMethod;

import lombok.ToString;

@ToString
public class Car {
    private String brand;
    private String color;

    private Car(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    public static Car brandBlackFrom(String brand){
        return new Car(brand, "black");
    }

    public static Car brandColorOf(String brand, String color){
        return new Car(brand, color);
    }
}
