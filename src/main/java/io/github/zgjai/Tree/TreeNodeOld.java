package io.github.zgjai.Tree;

import io.github.zgjai.Stack.MyStack;

import java.util.function.Function;

/**
 * Created by zhangguijiang on 2018/3/2.
 */
class TreeNodeOld {
    int val;
    TreeNodeOld left;
    TreeNodeOld right;

    TreeNodeOld(int val) {
        this.val = val;
    }

    // 深度优先遍历(DFS)
    // 先序遍历
    // 递归
    public static void preOrderRecursion(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        function.apply(root);
        preOrderRecursion(root.left, function);
        preOrderRecursion(root.right, function);
    }

    // 非递归
    public static void preOrderIteration(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        MyStack<TreeNodeOld> stack = new MyStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodeOld node = stack.pop();
            function.apply(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 中序遍历
    // 递归
    public static void inOrderRecursion(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left, function);
        function.apply(root);
        inOrderRecursion(root.right, function);
    }

    // 非递归
    public static void inOrderIteration(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        MyStack<TreeNodeOld> stack = new MyStack<>();
        TreeNodeOld node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                function.apply(node);
                node = node.right;
            }
        }
    }

    // 后序遍历
    // 递归
    public static void postOrderRecursion(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        postOrderRecursion(root.left, function);
        postOrderRecursion(root.right, function);
        function.apply(root);
    }

    // 非递归
    public static void postOrderIteration(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
        if (root == null) {
            return;
        }
        MyStack<TreeNodeOld> stack = new MyStack<>();
        MyStack<TreeNodeOld> output = new MyStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodeOld node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            output.push(node);
        }
        while (!output.isEmpty()) {
            function.apply(output.pop());
        }
    }

    // 广度优先遍历(BFS)，即层次遍历
    // 非递归
    public static void breadFirstIteration(TreeNodeOld root, Function<TreeNodeOld, Void> function) {
    }

    // 递归
    public static void breadFirstRecursion(TreeNodeOld root, Function<TreeNodeOld, Void> function) {

    }
}
