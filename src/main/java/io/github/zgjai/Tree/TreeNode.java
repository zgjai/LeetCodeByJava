package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/4/18
 */
public class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.value = data;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T data) {
        this.value = data;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(T data) {
        this.left = new TreeNode<>(data);
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public boolean hasRight() {
        return right != null;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(T data) {
        this.right = new TreeNode<>(data);
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}
