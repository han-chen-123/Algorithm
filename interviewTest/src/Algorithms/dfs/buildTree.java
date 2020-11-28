package Algorithms.dfs;

/*LeetCode 106. 从中序与后序遍历序列构造二叉树
        根据一棵树的中序遍历与后序遍历构造二叉树。

        注意:
        你可以假设树中没有重复的元素。

        例如，给出

        中序遍历 inorder = [9,3,15,20,7]
        后序遍历 postorder = [9,15,7,20,3]
        返回如下的二叉树：

        3
        / \
        9  20
        /  \
        15   7*/

public class buildTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd){
            return null;
        }

        int rootIndex = inStart;
        while(inorder[rootIndex] != postorder[postEnd]){
            rootIndex++;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = dfs(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - inStart - 1);
        root.right = dfs(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);
        return root;
    }
}
