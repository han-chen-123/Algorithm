package Algorithms.dfs;

/*LeetCode 101. 对称二叉树
        给定一个二叉树，检查它是否是镜像对称的。



        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
        / \
        2   2
        / \ / \
        3  4 4  3


        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
        / \
        2   2
        \   \
        3    3*/

public class isSymmetric {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null){
            return true;
        }

        if (r1 == null || r2 == null){
            return false;
        }

        return (r1.val == r2.val) && dfs(r1.left, r2.right) && dfs(r1.right, r2.left);
    }
}
