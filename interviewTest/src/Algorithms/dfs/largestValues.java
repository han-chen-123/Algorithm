package Algorithms.dfs;

/*LeetCode 515. 在每个树行中找最大值
        您需要在二叉树的每一行中找到最大的值。

        示例：

        输入:

        1
        / \
        3   2
        / \   \
        5   3   9

        输出: [1, 3, 9]*/

import java.util.ArrayList;
import java.util.List;

public class largestValues {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int level){
        if (root == null){
            return;
        }

        if (level == list.size()){
            list.add(root.val);
        }else{
            list.set(level, Math.max(list.get(level), root.val));
        }

        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
    }
}
