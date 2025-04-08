package study.practice.designPattern.facade;

import java.util.HashMap;

public class Cashe {
    private HashMap<String, Row> cache = new HashMap<>();

    public void put(Row row){
        cache.put(row.getName(), row);
    }

    public Row get(String name) {
        return cache.get(name);
    }
}
