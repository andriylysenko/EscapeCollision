package com.asl.predicate;

/**
 * Created by asl on 10/2/17.
 */

public interface Predicate<T> {
    boolean test(T obj);
}
