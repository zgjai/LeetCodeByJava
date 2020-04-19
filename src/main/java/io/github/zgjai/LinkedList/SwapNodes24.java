package io.github.zgjai.LinkedList;

/**
 * Created by zhangguijiang on 2017/9/26.
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 */

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 */

/**
 * 解题思路：
 * 本质就是对整个链表分段进行反置
 */
public class SwapNodes24 {

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 0) {
            return head;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
