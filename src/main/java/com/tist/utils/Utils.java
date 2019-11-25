package com.tist.utils;

import com.tist.annotation.FunctionAnnotation;
import com.tist.annotation.SetValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Jack Lin
 */
public class Utils {
    public static void inject(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SetValue.class)) {
                SetValue setValue = field.getAnnotation(SetValue.class);
                field.setAccessible(true);
                try {
                    field.set(obj, setValue.value());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int countAnnotatedFunctions(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        int count = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(FunctionAnnotation.class)) {
                count++;
            }
        }
        return count;
    }
}
