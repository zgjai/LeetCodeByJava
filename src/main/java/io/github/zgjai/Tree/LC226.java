package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/7/11
 */
public class LC226 {

    /**
     * 翻转一棵二叉树。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 4 /   \ 2     7 / \   / \ 1   3 6   9 输出：
     * <p>
     * 4 /   \ 7     2 / \   / \ 9   6 3   1
     */

    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        swapLR(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapLR(TreeNode<Integer> curr) {
        TreeNode<Integer> tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;
    }
}
