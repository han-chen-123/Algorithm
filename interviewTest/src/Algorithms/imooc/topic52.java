package Algorithms.imooc;

/*83. 删除排序链表中的重复元素
        给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

        示例 1:

        输入: 1->1->2
        输出: 1->2
        示例 2:

        输入: 1->1->2->3->3
        输出: 1->2->3*/

public class topic52 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /*86. 分隔链表
    给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

    你应当保留两个分区中每个节点的初始相对位置。

    示例：

    输入：head = 1->4->3->2->5->2, x = 3
    输出：1->2->2->4->3->5*/

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);

        ListNode cur = head;
        ListNode lessCur = lessHead;
        ListNode moreCur = moreHead;

        while (cur != null){
            if (cur.val < x){
                lessCur.next = new ListNode(cur.val);
                lessCur = lessCur.next;
                cur = cur.next;
            }else {
                moreCur.next = new ListNode(cur.val);
                moreCur = moreCur.next;
                cur = cur.next;
            }
        }

        lessCur.next = moreHead.next;
        return lessHead.next;
    }

    /*328. 奇偶链表
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

    示例 1:

    输入: 1->2->3->4->5->NULL
    输出: 1->3->5->2->4->NULL
    示例 2:

    输入: 2->1->3->5->6->4->7->NULL
    输出: 2->3->6->7->1->5->4->NULL
    说明:

    应当保持奇数节点和偶数节点的相对顺序。
    链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。*/

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }















}
