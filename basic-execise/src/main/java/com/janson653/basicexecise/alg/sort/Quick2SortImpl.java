package com.janson653.basicexecise.alg.sort;

import java.util.Arrays;
import java.util.Objects;

// 分而治之；split
public class Quick2SortImpl<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (Objects.isNull(nums)) return;

        int N = nums.length;
        sort(nums, 0, N - 1);
    }

    public void sort(T[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // split

        int j = partition(nums, left, right);
        System.out.println("j=" + j);
        System.out.println(Arrays.toString(nums));

        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    public int partition(T[] nums, int left, int right) {
        int i = left;
        int j = right + 1;
        T pivot = nums[left];

        while (true) {
            while (less(nums[++i], pivot) && i != right) ;
            while (less(pivot, nums[--j]) && j != left) ;

            if (i >= j) break;
            swap(nums, i, j);
        }

        // todo left 与j换
        swap(nums, left, j);
        return j;
    }
}
