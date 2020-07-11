package io.github.zgjai.Tree;

import java.util.Map;

/**
 * @author guijiang.zhang
 * @date 2020/7/1
 */
public class LC105 {

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意: 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 返回如下的二叉树：
     * <p>
     * 3 / \ 9  20 /  \ 15   7
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int curr = preorder[0];
        int leftLength = indexMap.get(curr);
        return constructTree(preorder, inorder, 1, 1 + leftLength, 0, 1 + leftLength);
    }

    private TreeNode<Integer> constructTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft,
                                            int inRight) {
        return null;
    }

}
