package com.janson653.basicexecise.alg.sort;

import java.util.Objects;

/**
 * 空间O(1)
 * 时间O(n*n)
 */
public class SelectSortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[i])) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
        }
    }
}
