package com.janson653.basicexecise.alg.sort;

import java.util.Objects;

public class InsertionSortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;
        int N = nums.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j >0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }
}
