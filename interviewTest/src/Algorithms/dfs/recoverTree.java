package Algorithms.dfs;

/*LeetCode 99. 恢复二叉搜索树
        二叉搜索树中的两个节点被错误地交换。

        请在不改变其结构的情况下，恢复这棵树。

        示例 1:

        输入: [1,3,null,null,2]

        1
        /
        3
        \
        2

        输出: [3,1,null,null,2]

        3
        /
        1
        \
        2
        示例 2:

        输入: [3,1,4,null,null,2]

        3
        / \
        1   4
        /
        2

        输出: [2,1,4,null,null,3]

        2
        / \
        1   4
        /
        3
        进阶:

        使用 O(n) 空间复杂度的解法很容易实现。
        你能想出一个只使用常数空间的解决方案吗？*/

import java.util.ArrayList;
import java.util.List;

    public class recoverTree {
        public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).val >= list.get(i + 1).val){
                y = list.get(i + 1);
                if (x == null){
                    x = list.get(i);
                }
            }
        }

        if (x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void inorder(TreeNode root, List<TreeNode> list){
        if (root == null) return;
        inorder(root.left,  list);
        list.add(root);
        inorder(root.right, list);
    }
}
