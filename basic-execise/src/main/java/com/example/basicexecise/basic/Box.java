package com.example.basicexecise.basic;

public class Box<T> {
    private T object;

    public void set(T object) { this.object = object; }
    public T get() { return object; }
}