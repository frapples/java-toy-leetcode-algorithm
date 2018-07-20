package io.github.frapples.algorithm.leetcode.medium003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
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

    /** 首先想到的方案是：设i从0到N - 1遍历，计算从i开始的不重复子串的最大长度。时间复杂度为O(N^2)
     * 这里采用的一种剪枝策略：
     * 1. 假设发现字串[i, j)是i开始的最长不重复子串
     * 2. 那么[i, j + 1)一定不是不重复子串
     * 3. 那么当搜索以i - 1开始的最长不重复字串时，只需要搜索到[i - 1, j)这个区间就可以了。
     *
     * 不过这个剪枝似乎作用不太大。。。
     *
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

    /**
     * 前面思路是i从0到N - 1遍历，计算从i开始的最大不重复字串。
     * 那能否通过i + 1的某些结果，直接推导出i的结果？
     * 如果i + 1的结果为[i + 1, j)，那么i情况的结果为：
     *  1. 如果s[i]不出现在[i + 1, j)中，那么结果为[i, j)
     *  2. 如果s[i]出现在[i + 1, j)中，显然只出现一次，索引为k。那么结果为[i, k)
     *  最后需要一个map来存储情况i的结果中，字符到索引的映射
     *
     *  最终的时间复杂度为O(N)
     * 33ms 93.12%
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> cache = new HashMap<>();
        int[] ends = new int[s.length()];

        ends[s.length() - 1] = s.length();
        cache.put(s.charAt(s.length() - 1), s.length() - 1);

        for (int i = s.length() - 2; i >= 0; i--) {
            if (cache.containsKey(s.charAt(i))) {
                ends[i] = cache.get(s.charAt(i));
            } else {
                ends[i] = ends[i + 1];
            }
            // 仔细分析不难发现该循环次数累加起来总共不超过N次
            for (int j = ends[i]; j < ends[i + 1]; j++) {
                cache.remove(s.charAt(j));
            }
            cache.put(s.charAt(i), i);
        }

        int maxLength = 0;
        for (int i = 0; i < ends.length; i++) {
            maxLength = Math.max(maxLength, ends[i] - i);
        }
        return maxLength;
    }
}
