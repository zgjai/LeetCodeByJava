package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/6/30
 */
public class LC250 {

    /**
     * 给定一个二叉树，统计该二叉树数值相同的子树个数。
     * <p>
     * 同值子树是指该子树的所有节点都拥有相同的数值。
     * <p>
     * 示例：
     * <p>
     * 输入: root = [5,1,5,5,5,null,5]
     * <p>
     * 5 / \ 1   5 / \   \ 5   5   5
     * <p>
     * 输出: 4
     */

    private int count = 0;

    public int countUnivalSubtrees(TreeNode<Integer> root) {
        isUnivalSubtree(root);
        return count;
    }

    private boolean isUnivalSubtree(TreeNode<Integer> currNode) {
        if (currNode == null) {
            return true;
        }
        boolean left = isUnivalSubtree(currNode.left);
        boolean right = isUnivalSubtree(currNode.right);
        if (left && right) {
            if (currNode.right != null && currNode.right.val != currNode.val) {
                return false;
            }
            if (currNode.left != null && currNode.left.val != currNode.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
