package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/7/7
 */
public class LC979 {

    /**
     * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
     * <p>
     * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
     * <p>
     * 返回使每个结点上只有一枚硬币所需的移动次数。
     */
    private int result;

    public int distributeCoins(TreeNode<Integer> root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode<Integer> curr) {
        if (curr == null) {
            return 0;
        }
        int l = dfs(curr.left);
        int r = dfs(curr.right);
        result += Math.abs(l) + Math.abs(r);
        return curr.val - 1 + l + r;
    }
}
