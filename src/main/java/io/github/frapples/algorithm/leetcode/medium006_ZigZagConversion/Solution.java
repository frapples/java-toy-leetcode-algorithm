package io.github.frapples.algorithm.leetcode.medium006_ZigZagConversion;

/**
 * @author Frapples <isfrapples@outlook.com>
 * @date 2019/5/28
 *
 * Question: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *
 *  And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows.
 *
 * 翻译：字符串“PAYPALISHIRING”以Z字形图案写在给定数量的行上，如下所示:(以等宽字体显示此图案可获得更好的易读性）
 */
public class Solution {

    //  97.56%, 3 ms, 35.5 MB
    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1) {
            return s;
        }

        // 设[0, segmentLength)为一段
        int segmentLength = numRows + numRows - 2;
        int segmentCount = groupNumber(s.length(), segmentLength);
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < numRows; line++) {
            for (int i = 0; i <= segmentCount; i++) {
                int start = i * segmentLength;
                int end = start + segmentLength;

                if (line == 0 || line == numRows - 1) {
                    if (start + line < s.length()) {
                        sb.append(s.charAt(start + line));
                    }
                } else {
                    if (start + line < s.length()) {
                        sb.append(s.charAt(start + line));
                    }
                    if (end - line < s.length()) {
                        sb.append(s.charAt(end - line));
                    }
                }
            }
        }
        return sb.toString();
    }

    private int groupNumber(int total, int groupCount) {
        return (total - 1) / groupCount + 1;
    }
}
