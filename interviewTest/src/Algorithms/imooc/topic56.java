package Algorithms.imooc;

/*19. 删除链表的倒数第 N 个结点
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

        进阶：你能尝试使用一趟扫描实现吗？

        示例 1：


        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：

        输入：head = [1], n = 1
        输出：[]
        示例 3：

        输入：head = [1,2], n = 1
        输出：[1]*/

public class topic56 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0; i < n + 1; i++){
            q = q.next;
        }

        while (q != null){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }
}
