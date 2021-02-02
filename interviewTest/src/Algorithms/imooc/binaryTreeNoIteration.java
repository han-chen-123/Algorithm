package Algorithms.imooc;

//二叉树遍历非递归

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class binaryTreeNoIteration {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void preoder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode p = null;
        while(!s.isEmpty()){
            p = s.pop();
            if (p != null){
                System.out.println(p.val);
                s.push(p.right);
                s.push(p.left);
            }
        }

    }


    public void inorder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        do {
            while(p != null){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.println(p.val);
            if (p.right != null){
                p = p.right;
            }else{
                p = null;
            }

        }while(p != null || !s.empty());
    }


    public void postOrder(TreeNode root) {

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while(p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.print(p.val+" ");
            //这里需要判断一下，当前p是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲p复制为NULL
            //取根节点
            if (!s.empty() && p == s.peek().left) {
                p = s.peek().right;
            }
            else p = null;
        }
    }









}
