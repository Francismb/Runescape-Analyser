package org.rs.analysis.utility.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class Reflection {

    public static Field getField(final Class clazz, final String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            try {
                field = clazz.getField(fieldName);
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }
        }
        return field;
    }

    public static Object getValue(final Class clazz, final String fieldName, final Object instance) {
        return getValue(clazz, getField(clazz, fieldName), instance);
    }

    public static Object getValue(final Class clazz, final Field field, final Object instance) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getValue(final ReflectiveField<T> reference) {
        try {
            final Field field = getField(reference.clazz, reference.fieldName);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return (T) field.get(reference.instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T[] getArray(final ReflectiveField<T> reference) {
        final Object object = getValue(reference);
        final Class type = object.getClass();
        final int length = Array.getLength(object);
        final Object[] array = (T[]) Array.newInstance(type, length);
        for (int i = 0; i < length; i++) {
            array[i] = Array.get(object, i);
        }
        return (T[]) array;
    }

}
