package list;

import java.util.List;

public class RemoveElements {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(5);
        ListNode root4 = new ListNode(2);
        root.next = root1;
//        root1.next = root2;
//        root2.next = root3;
//        root3.next = root4;
        System.out.println((new RemoveElements()).removeElements(root , 1));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = (new ListNode(0));
        dummy.next = head;
        ListNode dummyEnd = dummy;
        while (dummyEnd !=null && dummyEnd.next != null) {
            if (dummyEnd.next.val == val) {
                dummyEnd.next = dummyEnd.next.next;
            } else {
                dummyEnd = dummyEnd.next;
            }
        }
        return dummy.next;
    }
}
