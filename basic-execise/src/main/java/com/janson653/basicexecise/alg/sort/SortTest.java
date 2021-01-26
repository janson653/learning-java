package com.janson653.basicexecise.alg.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Sort sort = new Quick2SortImpl();
        Integer[] input = new Integer[]{2, 1, 5, 3, 9, 0};
//        String[] input = new String[]{"2", "1", "5", "3"};
        sort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}
