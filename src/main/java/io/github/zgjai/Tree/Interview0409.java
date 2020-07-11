package io.github.zgjai.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guijiang.zhang
 * @date 2020/5/26
 */
public class Interview0409 {
    /**
     * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。
     *
     * 示例:
     * 给定如下二叉树
     *
     *         2
     *        / \
     *       1   3
     * 返回:
     *
     * [
     *    [2,1,3],
     *    [2,3,1]
     * ]
     *
     */
    private List<List<Integer>> result;

    public List<List<Integer>> BSTSequences(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode<Integer>> currLevel = new ArrayList<>();
        currLevel.add(root);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(currLevel, track);
        return result;
    }

    private void backtrack(List<TreeNode<Integer>> currLevel, LinkedList<Integer> track) {
        if (currLevel.size() == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        List<TreeNode<Integer>> nextLevel = new ArrayList<>(currLevel);
        for (TreeNode<Integer> curr : currLevel) {
            track.add(curr.val);
            nextLevel.remove(curr);
            if (curr.left != null) { nextLevel.add(curr.left); }
            if (curr.right != null) { nextLevel.add(curr.right); }
            backtrack(nextLevel, track);
            if (curr.left != null) { nextLevel.remove(curr.left); }
            if (curr.right != null) { nextLevel.remove(curr.right); }
            nextLevel.add(curr);
            track.removeLast();
        }
    }
}
