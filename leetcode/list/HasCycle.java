package list;

import java.util.HashMap;
import java.util.HashSet;

public class HasCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        System.out.println(hasCycle(n1));
    }

    private static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.next)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    private static boolean hasX(ListNode head, ListNode head2) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
        }
        while (head2 != null) {
            if (set.contains(head2)) {
                return true;
            }
        }
        return false;
    }
}
