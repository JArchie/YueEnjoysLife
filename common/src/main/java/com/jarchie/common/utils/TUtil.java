package com.jarchie.common.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Jarchie on 2018\1\24.
 * 类转换初始化
 */

@SuppressWarnings({"unchecked", "EmptyCatchBlock"})
public class TUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
