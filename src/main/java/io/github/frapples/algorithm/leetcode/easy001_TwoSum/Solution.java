package io.github.frapples.algorithm.leetcode.easy001_TwoSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Question:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 翻译：
 * 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。
 * 您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
 */
class Solution {

    /** 方案一：
     * 首先将数组排序，然后对排序的数组进行二分查找。时间复杂度O(n*lgn)
     * 这种方案省空间
     * 40ms
     */
    public static int[] twoSum(int[] nums, int target) {
        Integer[] originIndex = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            originIndex[i] = i;
        }
        Arrays.sort(originIndex, Comparator.comparingInt(i -> nums[i]));
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            int index = Arrays.binarySearch(nums, i + 1, nums.length, need);
            if (index >= 0) {
                int a = originIndex[index];
                int b = originIndex[i];
                return new int[]{Math.min(a, b), Math.max(a, b)};
            }
        }
        return null;
    }

    /** 方案二：
     * 把数记录到hash表中去，可能有重复的，再用LinkedList记录 时间复杂度：O(n)
     * 8ms, 88.52%
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, List<Integer>> indexs = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!indexs.containsKey(nums[i])) {
                indexs.put(nums[i], new LinkedList<>());
            }
            indexs.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            List<Integer> is = indexs.get(need);
            if (!is.isEmpty() && !(is.size() == 1 && is.get(0) == i)) {
                int index = is.get(is.size() - 1);
                return new int[]{Math.min(i, index), Math.max(i, index)};
            }
        }
        return null;
    }

    /*
    * 方案三：方案二继续优化，可以只使用一个整数映射整数的hash表存储。时间复杂度：O(n)
    * 其关键在于重复的元素。对于重复的元素可以分析得出：
    * 1. 如果重复的元素不是解，这种情况，不管记录一个记录多个甚至不记录都不影响
    * 2. 如果重复的元素是解，由于题目说只有一个解决方案，因此只有两个重复的元素。
    *       由于搜索时从前往后搜索，一定是遍历到前面然后查找后面那个，所以map中只需记录后面那个的索引
    * 4ms, 99.65%
    * */
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> indexs = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
                indexs.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer index = indexs.get(need);
            // 注意需要检查一种特殊情况，如[3, 4, 2] 6，3可能被重复搜索导致返回结果[0, 0]
            if (index != null && index != i) {
                return new int[]{Math.min(i, index), Math.max(i, index)};
            }
        }
        return null;
    }
}
