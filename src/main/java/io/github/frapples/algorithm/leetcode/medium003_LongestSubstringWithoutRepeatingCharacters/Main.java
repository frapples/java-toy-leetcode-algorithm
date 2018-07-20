package io.github.frapples.algorithm.leetcode.medium003_LongestSubstringWithoutRepeatingCharacters;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring2("sprqswlnbi");
        out.println(result);
        result = solution.lengthOfLongestSubstring2("pwwkew");
        out.println(result);
        result = solution.lengthOfLongestSubstring2("cdd");
        out.println(result);
    }

}
