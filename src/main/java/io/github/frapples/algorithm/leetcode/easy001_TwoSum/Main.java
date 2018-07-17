package io.github.frapples.algorithm.leetcode.easy001_TwoSum;

import static java.lang.System.out;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum3(new int[]{3, 2, 4, 11}, 6);
        out.println(Arrays.toString(result));
    }
}
