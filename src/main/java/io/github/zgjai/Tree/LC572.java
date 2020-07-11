package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/7/5
 */
public class LC572 {

    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * <p>
     * 示例 1: 给定的树 s:
     * <p>
     * 3 / \ 4   5 / \ 1   2 给定的树 t：
     * <p>
     * 4 / \ 1   2 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 2: 给定的树 s：
     * <p>
     * 3 / \ 4   5 / \ 1   2 / 0 给定的树 t：
     * <p>
     * 4 / \ 1   2 返回 false。
     */
    public boolean isSubtree(TreeNode<Integer> s, TreeNode<Integer> t) {
        return dfs(s, t);
    }

    private boolean dfs(TreeNode<Integer> s, TreeNode<Integer> t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean check(TreeNode<Integer> s, TreeNode<Integer> t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (!s.val.equals(t.val)) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
