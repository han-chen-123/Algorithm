package Algorithms.imooc;

/*206. 反转链表
        反转一个单链表。

        示例:

        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL*/

import java.util.List;

public class topic51 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /*92. 反转链表 II
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

    说明:
            1 ≤ m ≤ n ≤ 链表长度。

    示例:

    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL*/

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;

        int step = 0;
        while (step < m - 1){
            pre = pre.next;
            cur = cur.next;
            step++;
        }

        for (int i = 0; i < n - m; i++){
            ListNode remove = cur.next;
            cur.next = cur.next.next;
            remove.next = pre.next;
            pre.next = remove;
        }
        return dummy.next;
    }













}
