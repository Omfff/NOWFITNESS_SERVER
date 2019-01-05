package com.example.demo1.util;

 /**
  * @Description:  自定义键值对
  */
public class PairUtils<T, V> {
    private T key;
    private V value;

    public PairUtils(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
