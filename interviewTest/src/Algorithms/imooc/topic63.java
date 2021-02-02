package Algorithms.imooc;

//144 前序遍历

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class topic63 {
    private class TreeNode {
        int val;
        binaryTreeNoIteration.TreeNode left;
        binaryTreeNoIteration.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = null;
        while (!stack.isEmpty()){
            p = stack.pop();
            if (p != null){
                res.add(p.val);
                stack.push(p.right);
                stack.push(p.left);
            }
        }

        return res;
    }
}
