package io.github.zgjai.Tree;

import io.github.zgjai.Stack.MyStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author guijiang.zhang
 * @date 2020/4/18
 */
public class MyTree<T> {

    private TreeNode<T> root;

    public MyTree() {
    }

    public MyTree(T data) {
        this.root = new TreeNode<T>(data);
    }

    public MyTree(TreeNode<T> node) {
        this.root = node;
    }

    public List<T> preOrderRecur(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        result.add(currNode.getValue());
        result.addAll(preOrderRecur(currNode.getLeft()));
        result.addAll(preOrderRecur(currNode.getRight()));
        return result;
    }

    public List<T> inOrderRecur(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        result.addAll(inOrderRecur(currNode.getLeft()));
        result.add(currNode.getValue());
        result.addAll(inOrderRecur(currNode.getRight()));
        return result;
    }

    public List<T> posOrderRecur(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        result.addAll(posOrderRecur(currNode.getLeft()));
        result.addAll(posOrderRecur(currNode.getRight()));
        result.add(currNode.getValue());
        return result;
    }

    public List<T> preOrderIteration(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        MyStack<TreeNode<T>> stack = new MyStack<>();
        stack.push(currNode);
        while (!stack.isEmpty()) {
            currNode = stack.pop();
            result.add(currNode.getValue());
            if (currNode.hasRight()) {
                stack.push(currNode.getRight());
            }
            if (currNode.hasLeft()) {
                stack.push(currNode.getLeft());
            }
        }
        return result;
    }

    public List<T> inOrderIteration(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        MyStack<TreeNode<T>> stack = new MyStack<>();
        TreeNode<T> node = currNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                result.add(node.getValue());
                node = node.getRight();
            }
        }
        return result;
    }

    public List<T> posOrderIteration(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        MyStack<TreeNode<T>> stack = new MyStack<>();
        MyStack<TreeNode<T>> output = new MyStack<>();
        TreeNode<T> node = currNode;
        while (!stack.isEmpty() || node != null) {
            if (node.hasLeft()) {
                stack.push(node.getLeft());
            }
            if (node.hasRight()) {
                stack.push(node.getRight());
            }
            output.push(node);
            node = stack.pop();
        }
        while (!output.isEmpty()) {
            node = output.pop();
            if (node != null) {
                result.add(node.getValue());
            }
        }
        return result;
    }

    public List<T> breadTraversal(TreeNode<T> currNode) {
        List<T> result = new ArrayList<>();
        if (currNode == null) {
            return result;
        }
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(currNode);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.getValue());
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }
        for (int i = result.size()-1; i >= 0; i--) {
            if (result.get(i) == null) {
                result.remove(i);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(2);
        root.getLeft().setLeft(3);
        root.getLeft().setRight(4);
        root.setRight(5);
        root.getRight().setLeft(6);
        root.getRight().setRight(7);
        root.getRight().getRight().setRight(8);
        MyTree<Integer> tree = new MyTree<>(root);
        System.out.println(tree.preOrderRecur(root));
        System.out.println(tree.preOrderIteration(root));
        System.out.println(tree.inOrderRecur(root));
        System.out.println(tree.inOrderIteration(root));
        System.out.println(tree.posOrderRecur(root));
        System.out.println(tree.posOrderIteration(root));
        System.out.println(tree.breadTraversal(root));
    }
}
