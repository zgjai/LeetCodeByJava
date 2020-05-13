package io.github.zgjai.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<List<Integer>> result = new ArrayList<>();
        boolean fromHead = false;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
