package io.github.zgjai.Tree;

import java.util.*;

/**
 * @author guijiang.zhang
 * @date 2020/5/12
 */
public class LC103 {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如： 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3 / \ 9  20 /  \ 15   7 返回锯齿形层次遍历如下：
     * <p>
     * [ [3], [20,9], [15,7] ]
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        return zigzagLevel(root);
    }

    private List<List<Integer>> zigzagLevel(TreeNode<Integer> currNode) {
        List<List<Integer>> result = new LinkedList<>();
        if (currNode == null) {
            return result;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(currNode);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode<Integer> node;
                node = queue.poll();
                if (node == null) {
                    list.add(null);
                    continue;
                }
                if (flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            flag = !flag;
            while (list.size() > 0 && list.peekLast() == null) {
                list.removeLast();
            }
            if (list.size() == 0) {
                continue;
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }

}
