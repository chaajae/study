package study.practice.designPattern.composite.practical;

import java.util.ArrayList;
import java.util.List;

public class Bag implements ItemComponent{
    public List<ItemComponent> components = new ArrayList<>();
    public String name;

    public Bag(String name) {
        this.name = name;
    }

    public void add(ItemComponent item){
        components.add(item);
    }

    public List<ItemComponent> getComponents(){
        return components;
    }

    @Override
    public int getPrice() {
        int sum = 0;

        for (ItemComponent component : components) {
            sum += component.getPrice();
        }
        return sum;
    }

    @Override
    public String getName() {
        return name;
    }
}
