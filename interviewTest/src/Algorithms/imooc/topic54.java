package Algorithms.imooc;

/*24. 两两交换链表中的节点
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

        示例 1：


        输入：head = [1,2,3,4]
        输出：[2,1,4,3]
        示例 2：

        输入：head = []
        输出：[]
        示例 3：

        输入：head = [1]
        输出：[1]


        提示：

        链表中节点的数目在范围 [0, 100] 内
        0 <= Node.val <= 100*/

public class topic54 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;
        }
        return dummyHead.next;
    }


    /*147. 对链表进行插入排序
    对链表进行插入排序。


    插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

    插入排序算法：

    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。


    示例 1：

    输入: 4->2->1->3
    输出: 1->2->3->4
    示例 2：

    输入: -1->5->3->4->0
    输出: -1->0->3->4->5*/

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head.next;
        ListNode lastSorted = head;
        while (cur != null){
            if (lastSorted.val <= cur.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummyHead;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }

            cur = lastSorted.next;
        }

        return dummyHead.next;
    }
}
