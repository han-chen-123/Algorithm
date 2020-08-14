package Algorithms.dfs;

/*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

        说明:叶子节点是指没有子节点的节点。

        示例:
        给定如下二叉树，以及目标和sum = 22，

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

import java.util.ArrayList;
import java.util.List;


public class pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtack(res, path, root, 0, sum);

        return res;
    }

    public void backtack(List<List<Integer>> res, List<Integer> path, TreeNode root, int temp, int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && temp + root.val == sum){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        backtack(res, path, root.left, temp + root.val, sum);
        backtack(res, path, root.right, temp + root.val, sum);
        path.remove(path.size() - 1);
    }
}
