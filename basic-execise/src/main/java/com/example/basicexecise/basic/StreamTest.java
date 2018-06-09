package com.example.basicexecise.basic;

import java.util.Arrays;
import java.util.function.Predicate;

public class StreamTest {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(array).reduce((i, j)->{return i+j;}));
    }
}
