package Algorithms.imooc;

/*347. 前 K 个高频元素
        给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



        示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]


        提示：

        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
        你可以按任意顺序返回答案。*/

import javafx.util.Pair;

import java.util.*;

public class topic67 {
    public int[] topKFrequent(int[] nums, int k) {

        //数字，频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        //频率，数字
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new PairComparator());
        for (Integer num : map.keySet()){
            int numFreq = map.get(num);
            if (queue.size() == k){
                if (numFreq > queue.peek().getKey()){
                    queue.poll();
                    queue.add(new Pair<>(numFreq, num));
                }
            }else {
                queue.add(new Pair<>(numFreq, num));
            }
        }

        int[] res = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll().getValue();
        }

        return res;
    }

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2 ) {
            if (p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }


    /*23. 合并K个升序链表
    给你一个链表数组，每个链表都已经按升序排列。

    请你将所有链表合并到一个升序链表中，返回合并后的链表。



    示例 1：

    输入：lists = [[1,4,5],[1,3,4],[2,6]]
    输出：[1,1,2,3,4,4,5,6]
    解释：链表数组如下：
            [
            1->4->5,
            1->3->4,
            2->6
            ]
    将它们合并到一个有序链表中得到。
            1->1->2->3->4->4->5->6
    示例 2：

    输入：lists = []
    输出：[]
    示例 3：

    输入：lists = [[]]
    输出：[]*/

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode node : lists){
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()){
            ListNode cur = queue.poll();
            head.next = cur;
            head = head.next;
            if (cur.next != null) queue.add(cur.next);
        }

        return dummyHead.next;
    }
}
