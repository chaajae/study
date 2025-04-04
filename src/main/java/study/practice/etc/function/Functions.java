package study.practice.etc.function;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import study.practice.etc.gson.CustomGsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functions {
    public static <T> T typeConvert(Object target, Class<T> type){

        T result = null;
        Gson gson = new CustomGsonBuilder().getGsonWithDate();

        try {
            String str = null;
            if(target instanceof String){
                str = (String) target;
            }else{
                str = gson.toJson(target);
            }

            result = gson.fromJson(str, TypeToken.of(type).getType());

        }catch (Exception e){}finally {
            if(result == null){
                if(type == List.class){
                    result = (T) new ArrayList<>();
                }else if(type == Map.class){
                    result = (T) new HashMap<>();
                }else{
                    try {
                        result = type.getDeclaredConstructor().newInstance();
                    }catch (Exception err){}
                }
            }
        }
        return result;
    }

}
