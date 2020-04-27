package io.github.zgjai.Tree;

/**
 * @author guijiang.zhang
 * @date 2020/4/25
 */
public class LC96 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * 示例:
     *
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     */
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        if (n > 2) {
            num[2] = 2;
        }
        if (n<=2) {
            return num[n];
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                num[i] += num[i - j] * num[j - 1];
            }
            num[i] = num[i]*2;
            if (i%2 != 0) {
                num[i] += num[i/2] * num[i/2];
            }
        }


        return num[n];
    }

}
