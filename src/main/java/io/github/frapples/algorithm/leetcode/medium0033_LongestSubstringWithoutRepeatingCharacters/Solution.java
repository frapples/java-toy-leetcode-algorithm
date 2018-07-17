package io.github.frapples.algorithm.leetcode.medium0033_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

/**
 * Question:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 翻译：
 * 给定一个字符串，找到子字符串最长不重复子串的长度。（不重复不是指相邻的不重复，而是指某个字符最多只能出现一次）
 * 注意答案必须是子字符串，如"pwwkew"，答案是"wke"。"pwke"是子序列而不是子字符串。
 */
class Solution {

    /**
     * 77ms 16.43%
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> containedChar = new HashSet<>();
        int findedRight = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            containedChar.clear();
            int j;
            for (j = i; j < findedRight; j++) {
                if (containedChar.contains(s.charAt(j))) {
                    break;
                }
                containedChar.add(s.charAt(j));
            }
            maxLength = Math.max(maxLength, j - i);
            findedRight = j;
        }
        return maxLength;
    }
}
