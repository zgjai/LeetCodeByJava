package io.github.zgjai.LinkedList;

/**
 * Created by zhangguijiang on 2017/9/29.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/**
 * 解题思路：
 * 两两合并，类似于归并的方式
 */
public class MergekSortedLists23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList<>();
        Collections.addAll(nodeList, lists);
        while (true) {
            if (nodeList.size() == 1) {
                return nodeList.get(0);
            }
            List<ListNode> newNodeList = new ArrayList<>();
            for (int i = 0; i < nodeList.size(); i = i + 2) {
                if (i + 1 == nodeList.size()) {
                    newNodeList.add(nodeList.get(i));
                    break;
                }
                newNodeList.add(merge(nodeList.get(i), nodeList.get(i + 1)));
            }
            nodeList = newNodeList;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
