package io.github.frapples.algorithm.leetcode.medium005_LongestPalindromicSubstring;

import static java.lang.System.out;

/**
 * @author Frapples <isfrapples@outlook.com>
 * @date 2018/8/6
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        out.println(solution.longestPalindrome("babad"));
        out.println(solution.longestPalindrome("cbbd"));
        out.println(solution.longestPalindrome("ccc"));
        out.println(solution.longestPalindrome("abcda"));
    }

}
