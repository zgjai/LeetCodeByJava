package io.github.zgjai.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author guijiang.zhang
 * @date 2020/6/18
 */
public class LC199 {
    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,null,5,null,4] 输出: [1, 3, 4] 解释:
     * <p>
     * 1            <--- /   \ 2     3         <--- \     \ 5     4       <---
     */

    public List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> rightResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
                queue.add(null);
            } else {
                result.add(null);
            }
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i + 1) == null && result.get(i) != null) {
                rightResult.add(result.get(i));
            }
        }
        if (result.get(result.size() - 1) != null) {
            rightResult.add(result.get(result.size() - 1));
        }
        return rightResult;
    }
}
