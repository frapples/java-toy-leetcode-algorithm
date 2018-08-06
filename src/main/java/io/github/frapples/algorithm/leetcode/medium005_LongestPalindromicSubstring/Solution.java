package io.github.frapples.algorithm.leetcode.medium005_LongestPalindromicSubstring;

/**
 * Question:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 *
 * 翻译：给定一个字符串s，找到s中最长的回文子字符串。您可以假设s的最大长度为1000。
 */
class Solution {
    // 48.16%
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            while (j <= Math.min(i, s.length() - 1 - i) && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            int off = j - 1;
            if ((maxRight - maxLeft) < ((i + off) - (i - off))) {
                maxLeft = i - off;
                maxRight = i + off;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int j = 0;
                while (j <= Math.min(i, s.length() - 1 - i - 1) && s.charAt(i - j) == s.charAt(i + j + 1)) {
                    j++;
                }

                int off = j - 1;
                if ((maxRight - maxLeft) < ((i + off + 1) - (i - off))) {
                    maxLeft = i - off;
                    maxRight = i + off + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}
