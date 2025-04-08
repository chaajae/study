package study.practice.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeModelFactory {
    private static final Map<String, TreeModel> cashe = new HashMap<>();

    public static TreeModel getInstance(String key){
        if(cashe.containsKey(key)){
            return cashe.get(key);
        }else{
            TreeModel model = new TreeModel(key, new Object(), new Object());
            System.out.println("-- 나무 모델 객체 새로 생성 완료 --");
            cashe.put(key, model);
            return model;
        }
    }
}
