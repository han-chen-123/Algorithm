package Algorithms.imooc;

/*257. 二叉树的所有路径
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

public class topic74 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        if (root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for (String leftP : leftS){
            StringBuilder leftSb = new StringBuilder();
            leftSb.append(root.val).append("->").append(leftP);
            res.add(leftSb.toString());
        }

        List<String> rightS = binaryTreePaths(root.right);
        for (String rightP : leftS){
            StringBuilder rightSb = new StringBuilder();
            rightSb.append(root.val).append("->").append(rightP);
            res.add(rightSb.toString());
        }

        return res;
    }

    /*113. 路径总和 II
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

    说明: 叶子节点是指没有子节点的节点。

    示例:
    给定如下二叉树，以及目标和 sum = 22，

            5
            / \
            4   8
            /   / \
            11  13  4
            /  \    / \
            7    2  5   1
    返回:

            [
            [5,4,11,2],
            [5,8,4,5]
            ]*/

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

    }


    /*129. 求根到叶子节点数字之和
    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

    例如，从根到叶子节点路径 1->2->3 代表数字 123。

    计算从根到叶子节点生成的所有数字之和。

    说明: 叶子节点是指没有子节点的节点。

    示例 1:

    输入: [1,2,3]
            1
            / \
            2   3
    输出: 25
    解释:
    从根到叶子节点路径 1->2 代表数字 12.
    从根到叶子节点路径 1->3 代表数字 13.
    因此，数字总和 = 12 + 13 = 25.
    示例 2:

    输入: [4,9,0,5,1]
            4
            / \
            9   0
            / \
            5   1
    输出: 1026
    解释:
    从根到叶子节点路径 4->9->5 代表数字 495.
    从根到叶子节点路径 4->9->1 代表数字 491.
    从根到叶子节点路径 4->0 代表数字 40.
    因此，数字总和 = 495 + 491 + 40 = 1026.*/

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int i){
        if (root == null){
            return 0;
        }
        int temp = 10 * i + root.val;
        if (root.left == null && root.right == null){
            return temp;
        }

        return sumNumbersHelper(root.left, temp) + sumNumbersHelper(root.right, temp);
    }
}
