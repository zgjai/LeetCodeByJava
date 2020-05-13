package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/4/28
 */
public class LC99 {
    /**
     * 二叉搜索树中的两个节点被错误地交换。
     * <p>
     * 请在不改变其结构的情况下，恢复这棵树。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,null,null,2]
     * <p>
     *    1   /  3   \    2
     * <p>
     * 输出: [3,1,null,null,2]
     * <p>
     *    3   /  1   \    2 示例 2:
     * <p>
     * 输入: [3,1,4,null,null,2]
     * <p>
     * 3 / \ 1   4    /   2
     * <p>
     * 输出: [2,1,4,null,null,3]
     * <p>
     * 2 / \ 1   4    /  3 进阶:
     * <p>
     * 使用 O(n) 空间复杂度的解法很容易实现。 你能想出一个只使用常数空间的解决方案吗？
     */

    public void recoverTree(TreeNode<Integer> root) {
        // predecessor is a Morris predecessor.
        // In the 'loop' cases it could be equal to the node itself predecessor == root.
        // pred is a 'true' predecessor,
        // the previous node in the inorder traversal.
        TreeNode<Integer> x = null, y = null, pred = null, predecessor = null;

        while (root != null) {
            // If there is a left child
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (root.left != null) {
                // Predecessor node is one step left
                // and then right till you can.
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) { predecessor = predecessor.right; }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // check for the swapped nodes
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) { x = pred; }
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // check for the swapped nodes
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) { x = pred; }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }

    public void swap(TreeNode<Integer> a, TreeNode<Integer> b) {
        Integer tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

}
