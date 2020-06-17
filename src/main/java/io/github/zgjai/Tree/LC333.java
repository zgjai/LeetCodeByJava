package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/6/11
 */
public class LC333 {

    /**
     * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
     * <p>
     * 注意: 子树必须包含其所有后代。
     * <p>
     * 示例:
     * <p>
     * 输入: [10,5,15,1,8,null,7]
     * <p>
     * 10 / \ 5  15 / \   \ 1   8   7
     * <p>
     * 输出: 3 解释: 高亮部分为最大的 BST 子树。 返回值 3 在这个样例中为子树大小。 进阶: 你能想出用 O(n) 的时间复杂度解决这个问题吗？
     */

    public int largestBSTSubtree(TreeNode<Integer> root) {
        BSTResult result = isBST(root);
        return result.size;
    }

    private BSTResult isBST(TreeNode<Integer> currNode) {
        if (currNode == null) {
            return new BSTResult();
        }
        BSTResult left = isBST(currNode.left);
        BSTResult right = isBST(currNode.right);
        BSTResult curr = new BSTResult();
        if (!left.isBST || !right.isBST || currNode.val < left.max || currNode.val > right.min) {
            curr.size = Math.max(left.size, right.size);
            curr.isBST = false;
            return curr;
        }
        curr.size = left.size + right.size + 1;
        if (currNode.val < left.min) {
            curr.min = currNode.val;
        } else {
            curr.min = left.min;
        }
        if (currNode.val > right.max) {
            curr.max = currNode.val;
        } else {
            curr.max = right.max;
        }
        return curr;
    }

    private static class BSTResult {
        public int size;
        public boolean isBST;
        public int min;
        public int max;

        public BSTResult() {
            this.size = 0;
            this.isBST = true;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }
}
