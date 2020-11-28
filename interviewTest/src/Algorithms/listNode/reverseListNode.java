package Algorithms.listNode;
//所有链表问题都能使用双指针解决，快慢指针，同步指针
/*
LeetCode 206. 反转链表
        反转一个单链表。

        示例:

        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
*/

public class reverseListNode {
    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){ this.val = val;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

        return pre;
    }
}
