package com.janson653.basicexecise.alg.sort;

import java.util.Objects;

public class ShellSortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;
        int N = nums.length;

        // 间隔多少个交换
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        System.out.println(h);

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(nums[j], nums[j - h])) {
                        swap(nums, j - h, j);
                    }
                }
            }
            h = h / 3;
        }
    }
}
