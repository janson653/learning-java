package com.janson653.basicexecise.alg.sort;

import java.util.Objects;

public class BubbleSortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;
        int N = nums.length;
        int count = 0;
        for (int i = N - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                count++;
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j + 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("swap count="+count);
    }
}
