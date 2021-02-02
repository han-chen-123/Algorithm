package Algorithms.imooc;

/*226. 翻转二叉树
        翻转一棵二叉树。

        示例：

        输入：

        4
        /   \
        2     7
        / \   / \
        1   3 6   9
        输出：

        4
        /   \
        7     2
        / \   / \
        9   6 3   1*/

public class topic72 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /*100. 相同的树
    给定两个二叉树，编写一个函数来检验它们是否相同。

    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

    示例 1:

    输入:       1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    输出: true
    示例 2:

    输入:      1          1
            /           \
            2             2

            [1,2],     [1,null,2]

    输出: false
    示例 3:

    输入:       1         1
            / \       / \
            2   1     1   2

            [1,2,1],   [1,1,2]

    输出: false*/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*101. 对称二叉树
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return cmp(root.left, root.right);
    }

    public boolean cmp(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null || left.val != right.val){
            return false;
        }

        return cmp(left.left, right.right) && cmp(left.right, right.left);
    }

    /*222. 完全二叉树的节点个数
    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

    完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。



    示例 1：


    输入：root = [1,2,3,4,5,6]
    输出：6
    示例 2：

    输入：root = []
    输出：0
    示例 3：

    输入：root = [1]
    输出：1*/

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        int right = countNodes(root.right);
        int left = countNodes(root.left);

        return right + left + 1;

    }

    /*110. 平衡二叉树
    给定一个二叉树，判断它是否是高度平衡的二叉树。

    本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。



    示例 1：


    输入：root = [3,9,20,null,null,15,7]
    输出：true
    示例 2：


    输入：root = [1,2,2,3,3,null,null,4,4]
    输出：false
    示例 3：

    输入：root = []
    输出：true*/

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return Math.abs(height(root.right) - height(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
