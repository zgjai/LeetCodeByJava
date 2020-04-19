package io.github.zgjai.LinkedList;

/**
 * Created by zhangguijiang on 2017/9/30.
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A: a1 → a2 ↘ c1 → c2 → c3 ↗ B: b1 → b2 → b3 begin to intersect at node c1. Notes: If the two linked lists have no
 * intersection at all, return null. The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure. Your code should preferably run in O(n)
 * time and use only O(1) memory.
 */

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A: a1 → a2 ↘
 * c1 → c2 → c3 ↗
 * B: b1 → b2 → b3 begin to intersect at node c1. Notes: If the two linked lists have no
 * intersection at all, return null. The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure. Your code should preferably run in O(n)
 * time and use only O(1) memory.
 */

/**
 * 解题思路：
 * 采用双指针，分别去遍历链表 a/b，在遍历完成后，分别去遍历另一个链表 b/a
 * 当两个指针的值相等时，即两个链表的交汇节点
 */

public class IntersectionofTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null ? headB : a.next);
            b = (b == null ? headA : b.next);
        }
        return a;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
