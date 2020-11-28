package Algorithms.dfs;

/*LeetCode 513. 找树左下角的值
        给定一个二叉树，在树的最后一行找到最左边的值。

        示例 1:

        输入:

        2
        / \
        1   3

        输出:
        1


        示例 2:

        输入:

        1
        / \
        2   3
        /   / \
        4   5   6
        /
        7

        输出:
        7*/

public class findBottomLeftValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max_level = 1;
    int left_value = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return left_value;
    }

    public void dfs(TreeNode root, int level){
        if (root == null){
            return;
        }

        if (level >= max_level){
            max_level = level;
            left_value = root.val;
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }

}
