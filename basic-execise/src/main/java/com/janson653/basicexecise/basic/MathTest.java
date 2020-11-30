package com.janson653.basicexecise.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathTest {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal(10000);
        BigDecimal r = new BigDecimal(0.001875);
        BigDecimal i = d.multiply(r);
        System.out.println(i.setScale(2, RoundingMode.HALF_UP));
        System.out.println(i.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(i.setScale(2, RoundingMode.HALF_EVEN));
    }
}
