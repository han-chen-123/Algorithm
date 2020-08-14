package Algorithms;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static String print(ListNode l){
        StringBuilder sb = new StringBuilder();
        while (l!= null){
            sb.append(l.val);
            l = l.next;
        }

        return sb.toString();
    }
}
