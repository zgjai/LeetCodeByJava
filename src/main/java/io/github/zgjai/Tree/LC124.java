package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/5/13
 */
public class LC124 {

    /**
     * 给定一个非空二叉树，返回其最大路径和。
     *
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     * 示例 2:
     *
     * 输入: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出: 42
     *
     */
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode<Integer> root) {
        treeMaxSum(root);
        return maxSum;
    }

    private int treeMaxSum(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        int leftMaxSum = Math.max(treeMaxSum(node.left), 0);
        int rightMaxSum = Math.max(treeMaxSum(node.right), 0);

        int sum = node.val + leftMaxSum + rightMaxSum;
        maxSum = Math.max(maxSum, sum);
        return node.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
