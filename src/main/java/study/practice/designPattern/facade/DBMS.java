package study.practice.designPattern.facade;

import java.util.HashMap;

public class DBMS {
    private HashMap<String, Row> db = new HashMap<>();

    public void put(String name, Row row){
        db.put(name, row);
    }

    public Row query(String name){
        try {
            Thread.sleep(500);
        }catch (Exception e){}
        return db.get(name.toLowerCase());
    }
}
