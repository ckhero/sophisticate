package list;

import java.util.List;

public class RemoveNthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       ListNode n1 = new ListNode(1);
       ListNode n2 = new ListNode(2);
       ListNode n3 = new ListNode(3);
       ListNode n4 = new ListNode(4);
       ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode aa = removeNthFromEnd(n1, 2);
        while (aa != null) {
            System.out.println(aa.val);
            aa = aa.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int len = 0;
        while (first != null) {
            len++;
            first = first.next;
        }
        len -= n;
        first = dummy;
        while (len > 0) {
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
