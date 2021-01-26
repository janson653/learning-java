package com.janson653.basicexecise.basic;

import java.math.BigInteger;

public class ShortTest {
    public static void main(String[] args) {
        int i = 111;
        int result = i * 31;
        int result2 = (i << 5) - i;
        System.out.println(result == result2);
    }
}
