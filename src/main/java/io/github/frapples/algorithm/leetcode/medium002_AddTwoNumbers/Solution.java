package io.github.frapples.algorithm.leetcode.medium002_AddTwoNumbers;

/**
 * Question:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 翻译：
 * 给你两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链接列表返回。
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 */
class Solution {
    /**
 * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 大数算法，题目说是非负数，只需要算加法。而且倒序存储，前面就是低位
     * 没什么难度,  O(max(M, N))时间复杂度
     *  28 ms 95.11%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 为了代码方便编写，给链表加个空的头节点
        ListNode resultHead = new ListNode(0);
        ListNode tail = resultHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int addedVal = val1 + val2 + carry;
            tail.next = new ListNode(addedVal % 10);
            carry = addedVal / 10;

            tail = tail.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return resultHead.next;
    }
}
