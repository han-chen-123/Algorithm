package Algorithms.imooc;

/*112. 路径总和
        给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

        叶子节点 是指没有子节点的节点。



        示例 1：


        输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        输出：true
        示例 2：


        输入：root = [1,2,3], targetSum = 5
        输出：false
        示例 3：

        输入：root = [1,2], targetSum = 0
        输出：false*/

public class topic73 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null){
            return sum == root.val;
        }

        if (hasPathSum(root.left, sum - root.val)){
            return true;
        }

        if (hasPathSum(root.right, sum - root.val)){
            return true;
        }

        return false;
    }

    /*404. 左叶子之和
    计算给定二叉树的所有左叶子之和。

    示例：

                 3
                / \
               9  20
                 /  \
                15   7

    在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24*/

    public int sumOfLeftLeaves(TreeNode root) {

        //所有节点之和
        /*if (root == null){
            return 0;
        }

        int leave = root.val;
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        return leave + left + right;*/

        //所有叶子节点之和
        /*if (root == null){
            return 0;
        }

        int leave = 0;
        if (root.right == null && root.left == null){
            leave = root.val;
        }

        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        return leave + left + right;*/

        return sumOfLeftLeavesHelper(root, false);
    }

    public int sumOfLeftLeavesHelper(TreeNode root, boolean flag){
        if (root == null){
            return 0;
        }

        int leave = 0;
        if (flag && root.left == null && root.right == null){
            leave = root.val;
        }

        int left = sumOfLeftLeavesHelper(root.left, true);
        int right = sumOfLeftLeavesHelper(root.right, false);

        return leave + left + right;
    }
}
