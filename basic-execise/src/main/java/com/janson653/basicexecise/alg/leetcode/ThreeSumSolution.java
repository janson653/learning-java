package com.janson653.basicexecise.alg.leetcode;

import java.util.*;

public class ThreeSumSolution {

    public static void main(String[] args) {
        ThreeSumSolution solution = new ThreeSumSolution();
        List<List<Integer>> lists = solution.threeSumV2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

    }

    /**
     * 1. 最笨的方法：可以考虑三层for循环实现
     * 2.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<String> findNums = new ArrayList<>();
                            findNums.add(String.valueOf(nums[i]));
                            findNums.add(String.valueOf(nums[j]));
                            findNums.add(String.valueOf(nums[k]));
                            Collections.sort(findNums);
                            set.add(String.join(",", findNums));
                        }
                    }
                }
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (String line : set) {
            String[] split = line.split(",");

            List<Integer> subList = new ArrayList<>();
            for (String item : split) {
                subList.add(Integer.parseInt(item));
            }
            results.add(subList);
        }
        return results;
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }

        // 保证有序
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        // 固定第一个数
        for (int first = 0; first < len; first++) {
            // 缩小第二个和第三个范围
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < third; ) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }

                if (nums[second] + nums[third] < target) {
                    second++;
                } else if (nums[second] + nums[third] > target) {
                    third--;
                } else {
                    // 找到了
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                }
            }
        }

        return ans;
    }


    public List<List<Integer>> threeSumOther(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}