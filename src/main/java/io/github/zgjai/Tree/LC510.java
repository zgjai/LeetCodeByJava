package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/7/1
 */
public class LC510 {

    public Node inorderSuccessor(Node node) {
        Node result = null;

        if (node.right != null) {
            result = node.right;
            while (result.left != null) {
                result = result.left;
            }
        } else {
            result = node;
            while (result.parent != null && result == result.parent.right) {
                result = result.parent;
            }
            result = result.parent;
        }

        return result;
    }

    ;

    /**
     * 510. 二叉搜索树中的中序后继 II 给定一棵二叉搜索树和其中的一个节点 node ，找到该节点在树中的中序后继。
     * <p>
     * 如果节点没有中序后继，请返回 null 。
     * <p>
     * 一个结点 node 的中序后继是键值比 node.val大所有的结点中键值最小的那个。
     * <p>
     * 你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。节点定义如下：
     * <p>
     * class Node { public int val; public Node left; public Node right; public Node parent; }
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你能否在不访问任何结点的值的情况下解决问题?
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
