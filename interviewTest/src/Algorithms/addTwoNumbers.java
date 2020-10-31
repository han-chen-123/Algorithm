package Algorithms;
/*给定两个用链表表示的整数，每个节点包含一个数位。

        这些数位是反向存放的，也就是个位排在链表首部。

        编写函数对这两个整数求和，并用链表形式返回结果。

        示例：

        输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
        输出：2 -> 1 -> 9，即912
        
        进阶：假设这些数位是正向存放的，请再做一遍。
        示例：

        输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
        输出：9 -> 1 -> 2，即912*/

import java.util.List;

public class addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;

        while (l1 != null || l2 != null || addOne != 0){
            int val1 = l1 == null ? 0: l1.val;
            int val2 = l2 == null ? 0: l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(1);
        l2.next = new ListNode(9);
        l1.next.next = new ListNode(6);
        l2.next.next = new ListNode(2);
        System.out.println(ListNode.print(addTwoNumbers(l1,l2)));
    }
}
