package study.practice.designPattern.dynamicFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DynamicShapeFactory {
    private static final Map<String, Class<? extends DShape>> registeredTypes = new HashMap<>();

    static {
        registeredTypes.put("Rectangle", DRectangle.class);
        registeredTypes.put("Circle", DCircle.class);
    }

    public static void registerType(String type, Class<? extends DShape> cls){
        registeredTypes.put(type, cls);
    }

    public static DShape create(String type, String color){
        DShape shape = null;
        try {
            shape = getShape(type);
            shape.setColor(color);
        }catch (Exception e){
            e.printStackTrace();
        }
        return shape;
    }

    private static DShape getShape(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cls = registeredTypes.get(type);

        Constructor<?> shapeConstructor = cls.getDeclaredConstructor();

        return (DShape) shapeConstructor.newInstance();

    }
}
