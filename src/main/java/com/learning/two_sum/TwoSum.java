package com.learning.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(getSum(nums, target)));
    }

    //方法一
    /*private static int[] getSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/

    //方法二
    /*private static int[] getSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if (map.containsKey(complment) && map.get(complment) != i) {
                return new int[]{i, map.get(complment)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }*/

    //方法三
    private static int[] getSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if (map.containsKey(complment) && map.get(complment) != i) {
                return new int[]{i, map.get(complment)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
