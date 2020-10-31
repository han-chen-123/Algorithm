package Algorithms;
/*给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

        示例1:

        输入: 1->1->2
        输出: 1->2
        示例2:

        输入: 1->1->2->3->3
        输出: 1->2->3*/

public class deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head){
        ListNode current = head;
        if (current.next == null) return head;

        while(current.next != null && current != null){
            if (current.next.val == current.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        deleteDuplicates test = new deleteDuplicates();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);

        System.out.println(ListNode.print(test.deleteDuplicates(listNode)));
    }
}
