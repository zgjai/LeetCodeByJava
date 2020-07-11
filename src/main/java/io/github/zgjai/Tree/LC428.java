package io.github.zgjai.Tree;

import java.util.List;

/**
 * @author guijiang.zhang
 * @date 2020/7/3
 */
public class LC428 {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        return null;
    }

    ;

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return null;
    }

    /**
     * 序列化是指将一个数据结构转化为位序列的过程，因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
     * <p>
     * 设计一个序列化和反序列化 N 叉树的算法。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。序列化 / 反序列化算法的算法实现没有限制。你只需要保证 N
     * 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
     * <p>
     * 注意：
     * <p>
     * N 的范围在 [1, 1000] 不要使用类成员 / 全局变量 / 静态变量来存储状态。你的序列化和反序列化算法应是无状态的。
     */

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
