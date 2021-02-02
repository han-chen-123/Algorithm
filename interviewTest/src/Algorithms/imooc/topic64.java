package Algorithms.imooc;

/*102. 二叉树的层序遍历
        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



        示例：
        二叉树：[3,9,20,null,null,15,7],

        3
        / \
        9  20
        /  \
        15   7
        返回其层序遍历结果：

        [
        [3],
        [9,20],
        [15,7]
        ]*/

import javafx.util.Pair;

import java.util.*;

public class topic64 {
    private class TreeNode {
        int val;
        binaryTreeNoIteration.TreeNode left;
        binaryTreeNoIteration.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.addLast(root);
        while (!queue.isEmpty()){
            res.add(new ArrayList<>());
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                res.get(res.size() - 1).add(node.val);

                if (node.left != null){
                    queue.addLast(node.left);
                }

                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.addLast(new Pair<>(root, 0));
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if (res.size() == level){
                res.add(new ArrayList<>());
            }

            res.get(level).add(node.val);
            if (node.left != null){
                queue.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null){
                queue.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }

        return res;
    }

    public void stackQueue(int num){
        //默认最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //最大堆
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(num, (a, b) -> b - a);


        class myCmp implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b){
                if(a%10 != b%10)
                    return a%10 - b%10;
                return a - b;
            }
        }
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(10, new myCmp());

    }




}
