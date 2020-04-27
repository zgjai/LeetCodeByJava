package io.github.zgjai.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guijiang.zhang
 * @date 2020/4/25
 */
public class LC95 {

    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
     *
     * 示例:
     *
     * 输入: 3
     * 输出:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释:
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     */
    public List<TreeNode<Integer>> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>(0);
        }
        return generateTree(1, n);
    }

    private List<TreeNode<Integer>> generateTree(int start, int end) {
        List<TreeNode<Integer>> allTreeList = new ArrayList<>();
        if (start > end) {
            return allTreeList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode<Integer>> leftTrees = generateTree(start, i - 1);
            List<TreeNode<Integer>> rightTrees = generateTree(i + 1, end);

            for (TreeNode<Integer> l : leftTrees) {
                for (TreeNode<Integer> r : rightTrees) {
                    TreeNode<Integer> currNode = new TreeNode<>(i);
                    currNode.setLeft(l);
                    currNode.setRight(r);
                    allTreeList.add(currNode);
                }
            }
        }
        return allTreeList;
    }
}
