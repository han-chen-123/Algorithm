package Algorithms.dfs;

/*LeetCode 257. 二叉树的所有路径
        给定一个二叉树，返回所有从根节点到叶子节点的路径。

        说明: 叶子节点是指没有子节点的节点。

        示例:

        输入:

        1
        /   \
        2     3
        \
        5

        输出: ["1->2->5", "1->3"]

        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3*/

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    public void dfs(TreeNode root, String path, List<String> paths){
        if (root.left == null && root.right == null){
            paths.add(path + root.val);
            return;
        }

        dfs(root.left, path + root.val + "->", paths);
        dfs(root.right, path + root.val + "->", paths);

    }
}
