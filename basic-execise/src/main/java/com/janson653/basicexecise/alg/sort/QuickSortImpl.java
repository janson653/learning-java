package com.janson653.basicexecise.alg.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快排思路
 */
public class QuickSortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;
        sort(nums, 0, nums.length - 1);
    }

    // low, high
    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }

        int j = partition(nums, l, h);
        System.out.println("j=" + j);
        System.out.println(Arrays.toString(nums));
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    // 难点，这里不会
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j) break;

            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
