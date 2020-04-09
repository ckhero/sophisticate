package list;

public class RotateRight {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);
        ListNode root4 = new ListNode(5);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        System.out.println((new RotateRight()).rotateRight(root , 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        int n = 1;
        while (end.next != null) {
            n++;
            end = end.next;
        }
        end.next = head;
        end = head;
        for (int i = 0; i < n - k - 1; i++) {
            end = end.next;
        }
        ListNode next = end.next;
        end.next = null;
        return next;
    }
}
