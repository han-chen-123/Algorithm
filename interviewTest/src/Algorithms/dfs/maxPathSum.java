package Algorithms.dfs;

/*LeetCode 124. 二叉树中的最大路径和
        给定一个非空二叉树，返回其最大路径和。

        本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。



        示例 1：

        输入：[1,2,3]

        1
        / \
        2   3

        输出：6
        示例 2：

        输入：[-10,9,20,null,null,15,7]

        -10
        / \
        9  20
        /  \
        15   7

        输出：42*/

public class maxPathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int rootLeft = dfs(root.left);
        int rootRight = dfs(root.right);
        int sum = rootLeft + rootRight + root.val;
        res = Math.max(res, sum);
        return Math.max(Math.max(root.val + rootLeft, root.val + rootRight), 0);
    }
}
