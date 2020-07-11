package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/7/5
 */
public class LC1120 {
    /**
     * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
     * <p>
     * 子树是树中的任意节点和它的所有后代构成的集合。
     * <p>
     * 树的平均值是树中节点值的总和除以节点数。
     * <p>
     * 输入：[5,6,1] 输出：6.00000 解释： 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。 以 value = 6 的节点作为子树的根节点，得到的平均值为 6
     * / 1 = 6。 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。 所以答案取最大值 6。
     * <p>
     * 提示：
     * <p>
     * 树中的节点数介于 1 到 5000之间。 每个节点的值介于 0 到 100000 之间。 如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。
     */

    private double max = 0;

    public double maximumAverageSubtree(TreeNode<Integer> root) {
        averageSubtree(root);
        return max;
    }

    private int[] averageSubtree(TreeNode<Integer> curr) {
        int[] result = new int[] {0, 0};
        if (curr == null) {
            return result;
        }
        int[] left = averageSubtree(curr.left);
        int[] right = averageSubtree(curr.right);
        int sum = left[0] + right[0] + curr.val;
        int count = left[1] + right[1] + 1;
        //BigDecimal bigDecimal = new BigDecimal(sum);
        // double average =bigDecimal.divide(new BigDecimal(count), RoundingMode.HALF_UP).doubleValue();
        double average = ((double)sum) / count;
        if (average > max) {
            max = average;
        }
        result[0] = sum;
        result[1] = count;
        return result;
    }
}
