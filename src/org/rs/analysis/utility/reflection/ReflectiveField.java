package org.rs.analysis.utility.reflection;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class ReflectiveField<T> {

    public final Class clazz;
    public final Object instance;
    public final String fieldName;
    private final int multiplier;

    private T cache;
    private long cache_time;

    public ReflectiveField(final Class clazz, final String fieldName) {
        this(clazz, fieldName, -1, null);
    }

    public ReflectiveField(final Class clazz, final String fieldName, final Object instance) {
        this(clazz, fieldName, -1, instance);
    }

    public ReflectiveField(final Class clazz, final String fieldName, final int multiplier, final Object instance) {
        this.clazz = clazz;
        this.fieldName = fieldName;
        this.multiplier = multiplier;
        this.instance = instance;
    }

    public T get() {
        if (System.currentTimeMillis() - cache_time > 300) {
            cache = (T) (multiplier != -1 ? ((Integer) Reflection.getValue(this)) * multiplier : Reflection.getValue(this));
            cache_time = System.currentTimeMillis();
        }
        return cache;
    }
}

